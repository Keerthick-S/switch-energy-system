import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { Router } from "@angular/router";
import { AddSmartmeterComponent } from "../add-smartmeter-component/add.smartmeter.component";
import { User, userDetails } from "../interface/user.interface";
import { SmartMeterService } from "../service/smartmeter.service";
import { UserService } from "../service/user.service";
import { UserSmartmeterComponent } from "../user-smartmeter-component/user.smartmeter.component";

@Component({
    selector : 'toolbar-component',
    templateUrl : './toolbar.component.html',
    styleUrls : ['./toolbar.component.css'],
    providers : [UserSmartmeterComponent]
})

export class ToolbarComponent implements OnInit {

    user : User = {
      id: "",
      name: "",
  }

    userDetail : userDetails = {
      userId: "",
      userName: "",
      provider: ""
    }

    constructor(private router : Router ,private smartmeterService : SmartMeterService, private userService : UserService , public dialog: MatDialog, private userSmartmeter : UserSmartmeterComponent) {
    }

    ngOnInit(): void {
      this.getUserSmartMeters();
    }

    addSmartMeter(): void {
      const dialogRef = this.dialog.open(AddSmartmeterComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        if(result) {
          this.userDetail.userId = this.user.id;
          this.userDetail.userName = this.user.name;
          this.userDetail.provider = result;
          this.smartmeterService.addSmartMeter(this.userDetail).subscribe(res => {
            this.userSmartmeter.getUserSmartMeter();
          });
        }
      });
    }

    getUserSmartMeters() : void {
      const userId = sessionStorage.getItem('userId');      
      this.userService.getUser(userId).subscribe(res => {
        this.user = res;
      })
    }

    userLogout() : void {
      sessionStorage.clear();
      this.router.navigateByUrl('login');
    }
}  