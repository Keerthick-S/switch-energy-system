import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { Router } from "@angular/router";
import { AddSmartmeterComponent } from "../add-smartmeter-component/add.smartmeter.component";
import { User, userDetails } from "../interface/user.interface";
import { SmartMeterService } from "../service/smartmeter.service";
import { UserService } from "../service/user.service";

@Component({
    selector : 'toolbar-component',
    templateUrl : './toolbar.component.html',
    styleUrls : ['./toolbar.component.css']
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

    constructor(private router : Router ,private smartmeterService : SmartMeterService, private userService : UserService , public dialog: MatDialog) {
    }

    ngOnInit(): void {
      this.userService.getUser(9150500151).subscribe(res => {
        this.user = res;
      })
    }

    openDialog(): void {
      const dialogRef = this.dialog.open(AddSmartmeterComponent);
  
      dialogRef.afterClosed().subscribe(result => {
        if(result) {
          this.userDetail.userId = this.user.id;
          this.userDetail.userName = this.user.name;
          this.userDetail.provider = result;
          this.smartmeterService.addSmartMeter(this.userDetail).subscribe();
        }
      });
    }
}  