import { Component, OnInit } from "@angular/core";
import { SmartMeter } from "../interface/smartmeter.interface";
import { SmartMeterService } from "../service/smartmeter.service";


@Component({
    selector : 'user-smartmeter-component',
    templateUrl : './user.smartmeter.component.html',
    styleUrls : ['./user.smartmeter.component.css']
})

export class UserSmartmeterComponent implements OnInit {

    smartMeters : SmartMeter[] = [];

    constructor(private smartmeterService : SmartMeterService) {
    }

    ngOnInit(): void {
        this.smartmeterService.getUserSmartmeter(9150500151).subscribe(res => {
            this.smartMeters = res;
        })
    }
}