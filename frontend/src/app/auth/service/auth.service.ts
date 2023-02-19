import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Token } from "../interface/token";

@Injectable({
    providedIn : 'root'
})

export class AuthService {

    userName : string = ''

    BASE_URL : string = 'http://localhost:8090/'

    constructor(private http : HttpClient) {
    }

    getToken(login : object) : Observable<Token> {
        return this.http.post<Token>(`${this.BASE_URL}authentication`, login);
    }

    isLoggedIn() : boolean {
        return !!sessionStorage.getItem('token');
    }    

    createUser(user : object) : Observable<object> {
        return this.http.post<object>(`${this.BASE_URL}user/create`, user);
    } 
}