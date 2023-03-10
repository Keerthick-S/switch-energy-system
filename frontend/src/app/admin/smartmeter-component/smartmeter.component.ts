import { Component, OnInit } from "@angular/core";
import { SmartMeter } from "../interface/smartmeter.interface";
import { SmartmeterService } from "../service/smartmeter.service";

@Component({
    selector : 'app-smartmeter-component',
    templateUrl : './smartmeter.component.html',
    styleUrls : ['./smartmeter.component.css']
})

export class SmartmeterComponent implements OnInit{

    page: number = 1;
    limit: number = 6;

    smartmeters : SmartMeter[] = [];

    constructor(private smartmeterService : SmartmeterService) {
    }

    ngOnInit(): void {
        this.getSmartMeters();
    }

    smartmeterStatus(id : string ,status : string) : void {    
        this.smartmeterService.setSmartMeterStatus(id, status).subscribe(res => {
            this.getSmartMeters();
        });
    }

    getSmartMeters() : void {
        this.smartmeterService.getPendingSmartmeter().subscribe({
            next : (res) => {
                this.smartmeters = res;
            }
        })
    }
}