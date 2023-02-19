import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { CreateProviderComponent } from './create-provider-component/create.provider.component';
import { ProviderComponent } from './provider-component/provider.component';
import { SmartmeterComponent } from './smartmeter-component/smartmeter.component';
import { ToolbarComponent } from './toolbar-component/toolbar.component';
import { MaterialModule } from '../material/material.module';
import { NgxPaginationModule } from 'ngx-pagination';

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
    MaterialModule,
    ReactiveFormsModule,
    AdminRoutingModule,
    NgxPaginationModule
  ]
})
export class AdminModule { }
