import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { AuthService } from "src/app/auth/service/auth.service";
import { AddSmartmeterComponent } from "../add-smartmeter-component/add.smartmeter.component";
import { SmartMeter } from "../interface/smartmeter.interface";
import { ProviderService } from "../service/provider.service";
import { SmartMeterService } from "../service/smartmeter.service";
import { ViewSmartmeterDialogComponent } from "../view-smartmeter-dialog-component/view.smartmeter.dialog.component";


@Component({
    selector : 'user-smartmeter-component',
    templateUrl : './user.smartmeter.component.html',
    styleUrls : ['./user.smartmeter.component.css']
})

export class UserSmartmeterComponent implements OnInit {

    smartMeters : SmartMeter[] = [];

    constructor(private smartmeterService : SmartMeterService,private providerService : ProviderService, public dialog: MatDialog, private authService : AuthService) {
    }

    ngOnInit(): void {
        this.getUserSmartMeter();
    }

    switchSmartMeter(smartMeterId : string) : void {
        const dialogRef = this.dialog.open(AddSmartmeterComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        if(result) {
          this.providerService.switchSmartMeterProvider(smartMeterId, result).subscribe({
            next : (res) => {
              this.getUserSmartMeter();
            }
          });
        }
      });
    }

    viewSmartMeter(smartmeter : string) : void {
        this.smartmeterService.viewSmartMeter(smartmeter).subscribe({
          next : (res) => {
            const dialogRef = this.dialog.open(ViewSmartmeterDialogComponent, {
              data: res,
            });
        
            dialogRef.afterClosed().subscribe();
          }
        })
    }

    getUserSmartMeter() : void {
      let userId = sessionStorage.getItem('userId');    
        this.smartmeterService.getUserSmartmeter(userId).subscribe({
          next : (res) => {
            this.smartMeters = res;
          }
        })
    }
}