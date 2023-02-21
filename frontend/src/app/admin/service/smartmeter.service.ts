import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { SmartMeter } from "../interface/smartmeter.interface";

@Injectable({
    providedIn : 'root'
})

export class SmartmeterService{

    BASE_URL : string = 'http://localhost:8090/smart-meter/';

    constructor(private http : HttpClient) {
    }

    getPendingSmartmeter() : Observable<SmartMeter[]> {
        return this.http.get<SmartMeter[]>(`${this.BASE_URL}pending-request`);
    }

    setSmartMeterStatus(id : string, status : string) : Observable<Object>{
        return this.http.put<Object>(`${this.BASE_URL}${status}/${id}`, null);
    }
}