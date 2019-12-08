// material.module.ts

import { NgModule } from '@angular/core';

import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule, MatSortModule,MatToolbarModule } from '@angular/material';
import {MatButtonModule} from "@angular/material";
import {MatInputModule} from "@angular/material";
import {MatCardModule} from "@angular/material";

@NgModule({
  imports: [
    MatToolbarModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    
  ],
  exports: [
    MatToolbarModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatToolbarModule
    
  ]
})

export class MaterialModule {}
