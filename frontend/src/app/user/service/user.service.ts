import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { SmartMeter } from "../interface/smartmeter.interface";
import { User } from "../interface/user.interface";

@Injectable({
    providedIn : 'root'
})

export class UserService {

    BASE_URL : string = 'http://localhost:8090/user/';

    constructor(private http : HttpClient) {
    }

    getUser(phoneNumber : number) : Observable<User> {
        return this.http.get<User>(`${this.BASE_URL}${phoneNumber}`);
    }
}