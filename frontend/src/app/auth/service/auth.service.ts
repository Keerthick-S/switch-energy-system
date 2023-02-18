import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn : 'root'
})

export class AuthService {

    constructor(private http : HttpClient) {
    }

    getToken(login : any) : Observable<any> {
        return this.http.post<any>(`http://localhost:8090/authentication`, login);
    }

    isLoggedIn() : boolean {
        return !!sessionStorage.getItem('token');
    }
    
}