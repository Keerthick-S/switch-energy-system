import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login-component/login.component';
import { SignupComponent } from './auth/signup-component/signup.component';

const routes: Routes = [
  {path: '', redirectTo: 'user', pathMatch: 'full'},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {
    path:'admin',
    loadChildren:() =>import('./admin/admin.module').then(x=>x.AdminModule)
  },
  {
    path:'user',
    loadChildren:() =>import('./user/user-routing.module').then(x=>x.UserRoutingModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
