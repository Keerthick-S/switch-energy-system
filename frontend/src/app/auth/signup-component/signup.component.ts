import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { Login } from "../interface/token";
import { AuthService } from "../service/auth.service";

@Component({
    selector: 'app-signup-component',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})

export class SignupComponent {

    login : Login = {
        userName : '',
        password : ''
    }

    constructor(private authService : AuthService, private router : Router,) {
    }

    loginForm = new FormGroup({
        name : new FormControl('', Validators.required),
        email: new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
        phoneNumber : new FormControl('', [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')]),
        password : new FormControl('', Validators.required)
    })

    createUser() : void{
        this.authService.createUser(this.loginForm.value).subscribe({
            next: (res) => {
                this.login.userName = this.loginForm.value.email;
                this.login.password = this.loginForm.value.password;

                this.authService.getToken(this.login).subscribe({
                    next : (res) => {
                        sessionStorage.setItem('token', res.token);
                        sessionStorage.setItem('role', res.role);
                        sessionStorage.setItem('userId', res.userId);
                        this.router.navigateByUrl('/user')
                    }
                });
            }
        })
    }

}