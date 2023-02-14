import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddSmartmeterComponent } from './add-smartmeter-component/add.smartmeter.component';
import { UserSmartmeterComponent } from './user-smartmeter-component/user.smartmeter.component';

const routes: Routes = [
  {path : '' , redirectTo : 'smartmeter', pathMatch : 'full'},
  {path : 'smartmeter', component: UserSmartmeterComponent},
  {path : 'add-smartmeter', component: AddSmartmeterComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class UserRoutingModule { }
