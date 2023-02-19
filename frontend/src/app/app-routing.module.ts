import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login-component/login.component';
import { AuthGuard } from './auth/service/auth.gaurd';
import { RoleGuard } from './auth/service/role.gaurd';
import { SignupComponent } from './auth/signup-component/signup.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {
    path:'admin',
    canActivate:[AuthGuard],
    loadChildren:() =>import('./admin/admin.module').then(x=>x.AdminModule),
    
  },
  {
    path:'user',
    canActivate:[AuthGuard],
    loadChildren:() =>import('./user/user-routing.module').then(x=>x.UserRoutingModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
