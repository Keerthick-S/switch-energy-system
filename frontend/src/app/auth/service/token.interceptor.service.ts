import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable, Injector } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn : 'root'
})

export class TokenInterceptor implements HttpInterceptor{

    constructor(private http:HttpClient, private injector : Injector) {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        let jwtToken: HttpRequest<any>;

        if(req.url === 'http://localhost:8090/authentication' || req.url === 'http://localhost:8090/user/add-user') {
            jwtToken = req.clone({
                setHeaders: {
                    Authorization: ''
                }
            })
        } else {
            let token = sessionStorage.getItem('token');        
            jwtToken = req.clone({
                setHeaders: {
                    Authorization: 'Bearer '+ token
                }
            })
        }
        return next.handle(jwtToken);
     }
}