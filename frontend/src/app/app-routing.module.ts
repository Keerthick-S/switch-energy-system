import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login-component/login.component';
import { AuthGuard } from './auth/service/auth.gaurd';
import { SignupComponent } from './auth/signup-component/signup.component';

const routes: Routes = [
  {path: '', redirectTo: 'user', pathMatch: 'full'},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {
    path:'admin',
    loadChildren:() =>import('./admin/admin.module').then(x=>x.AdminModule),
    canActivate:[AuthGuard]
  },
  {
    path:'user',
    loadChildren:() =>import('./user/user-routing.module').then(x=>x.UserRoutingModule),
    canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
