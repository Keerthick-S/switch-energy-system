import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "../service/auth.service";
import { TokenInterceptor } from "../service/token.interceptor.service";

@Component({
    selector : 'app-login-component',
    templateUrl : './login.component.html',
    styleUrls : ['./login.component.css']
})

export class LoginComponent{
    
    constructor(private authService: AuthService, private router : Router) {
    }

    loginForm = new FormGroup({
        userName: new FormControl('anu@gmail.com', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
        password: new FormControl('anu@22')
    })

    authenticate() : void {       
        this.authService.getToken(this.loginForm.value).subscribe(res => {
            sessionStorage.setItem('token', res.token);
            sessionStorage.setItem('role', res.role);
            sessionStorage.setItem('userId', res.userId);
            this.router.navigateByUrl('user');
         })
    }
}