import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
    providedIn: 'root'
})

export class RoleGuard implements CanActivate {
    constructor(private router : Router) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const role = sessionStorage.getItem("role");
        console.log(role);
        
        if(role == 'User') {
            this.router.navigateByUrl('/user');
            return true;
        } 
        return false;
    }
}