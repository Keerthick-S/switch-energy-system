import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import { UserRoutingModule } from './user-routing.module';

import { UserSmartmeterComponent } from './user-smartmeter-component/user.smartmeter.component';
import { ToolbarComponent } from './toolbar-component/toolbar.component';
import { AddSmartmeterComponent } from './add-smartmeter-component/add.smartmeter.component';
import { ViewSmartmeterDialogComponent } from './view-smartmeter-dialog-component/view.smartmeter.dialog.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    UserSmartmeterComponent,
    ToolbarComponent,
    AddSmartmeterComponent,
    ViewSmartmeterDialogComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    UserRoutingModule
  ]
})
export class UserModule { }
