import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatSelectModule } from '@angular/material/select';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field'

const materialComponent = [
  MatButtonModule,
  MatIconModule,
  MatInputModule,
  MatCardModule,
  MatMenuModule,
  MatSelectModule,
  MatToolbarModule,
  MatDialogModule,
  MatFormFieldModule
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  exports: [materialComponent]
})
export class MaterialModule { }
