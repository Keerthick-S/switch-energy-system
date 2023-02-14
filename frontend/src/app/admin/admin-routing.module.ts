import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProviderComponent } from './create-provider-component/create.provider.component';
import { ProviderComponent } from './provider-component/provider.component';
import { SmartmeterComponent } from './smartmeter-component/smartmeter.component';

const routes: Routes = [
  {path : 'add-provider' , component : CreateProviderComponent},
  {path : 'smartmeter' , component : SmartmeterComponent},
  {path : 'provider' , component : ProviderComponent},
  {path : '' , redirectTo : 'provider', pathMatch : 'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class AdminRoutingModule { }
