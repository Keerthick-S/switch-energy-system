import { Component, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { SmartMeterDetails } from "../interface/smartmeter.interface";
import { UserSmartmeterComponent } from "../user-smartmeter-component/user.smartmeter.component";

@Component({
    selector : 'view-smartmeter-dialog-component',
    templateUrl : './view.smartmeter.dialog.component.html',
    styleUrls : ['./view.smartmeter.dialog.component.css']
})

export class ViewSmartmeterDialogComponent {

    smartMeterDetails : SmartMeterDetails = {
        reading: 0,
        amount: 0,
        smartMeterId: ""
    }

    constructor( public dialogRef: MatDialogRef<UserSmartmeterComponent>,@Inject(MAT_DIALOG_DATA) public data: SmartMeterDetails,) {
        this.smartMeterDetails = data;
    }
    
      onNoClick(): void {
        this.dialogRef.close();
      }
}