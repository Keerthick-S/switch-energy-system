import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProviderComponent } from './create-provider-component/create.provider.component';
import { LoginComponent } from './login-component/login.component';
import { MainComponent } from './main-component/main.component';
import { ProviderComponent } from './provider-component/provider.component';
import { SignupComponent } from './signup-component/signup.component';
import { SmartmeterComponent } from './smartmeter-component/smartmeter.component';

const routes: Routes = [
  {path: '', redirectTo: 'main-page', pathMatch: 'full'},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path : 'smartmeter', component : SmartmeterComponent},
  {path : 'main-page', component : MainComponent},
  {path : 'provider' , component : ProviderComponent},
  {path : 'add-provider' , component : CreateProviderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
