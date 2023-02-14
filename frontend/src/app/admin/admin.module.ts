import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { CreateProviderComponent } from './create-provider-component/create.provider.component';
import { ProviderComponent } from './provider-component/provider.component';
import { SmartmeterComponent } from './smartmeter-component/smartmeter.component';

import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatSelectModule } from '@angular/material/select';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ToolbarComponent } from './toolbar-component/toolbar.component';


@NgModule({
  declarations: [
    ToolbarComponent,
    ProviderComponent,
    SmartmeterComponent,
    CreateProviderComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatInputModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
