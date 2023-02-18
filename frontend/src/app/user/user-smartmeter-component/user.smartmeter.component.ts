import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { AddSmartmeterComponent } from "../add-smartmeter-component/add.smartmeter.component";
import { SmartMeter } from "../interface/smartmeter.interface";
import { SmartMeterService } from "../service/smartmeter.service";


@Component({
    selector : 'user-smartmeter-component',
    templateUrl : './user.smartmeter.component.html',
    styleUrls : ['./user.smartmeter.component.css']
})

export class UserSmartmeterComponent implements OnInit {

    smartMeters : SmartMeter[] = [];

    constructor(private smartmeterService : SmartMeterService, public dialog: MatDialog) {
    }

    ngOnInit(): void {
        this.smartmeterService.getUserSmartmeter('anu@gmail.com').subscribe(res => {
            this.smartMeters = res;
        })
    }

    switchSmartMeter(smartMeterId : string) : void {
        const dialogRef = this.dialog.open(AddSmartmeterComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        if(result) {
          this.smartmeterService.switchSmartMeter(smartMeterId, result).subscribe();
        }
      });
    }
}