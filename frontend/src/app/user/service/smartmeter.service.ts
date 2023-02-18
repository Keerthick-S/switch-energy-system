import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { SmartMeter } from "../interface/smartmeter.interface";
import { userDetails } from "../interface/user.interface";

@Injectable({
    providedIn : 'root'
})

export class SmartMeterService {

    BASE_URL : string = 'http://localhost:8090/smart-meter';

    constructor(private http : HttpClient) {
    }

    getUserSmartmeter(email : string) : Observable<SmartMeter[]> {
        return this.http.get<SmartMeter[]>(`${this.BASE_URL}/${email}`);
    }

    addSmartMeter(userDetail : userDetails) : Observable<object> {
        return this.http.post<object>(`${this.BASE_URL}`, userDetail);
    }

    switchSmartMeter(smartMeterId : string, providerName : string) : Observable<object> {
        return this.http.put(`${this.BASE_URL}/${providerName}/${smartMeterId}`, null);
    }
}