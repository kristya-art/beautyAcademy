import { BrowserModule } from '@angular/platform-browser';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { CustomMaterialModule } from './core/material.module';

import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { LecturerComponent } from './lecturer/lecturer.component';
import { AdminComponent } from './admin/admin.component';

import {ɵHttpInterceptingHandler} from "@angular/common/http";
import { UserListComponent } from './user-list/user-list.component';
import {MatButtonModule} from "@angular/material";
import {MatCardModule} from "@angular/material/typings/esm5/card";
import {MatInputModule} from "@angular/material/typings/input";
import {MatListModule} from "@angular/material/typings/list";
import {MatToolbarModule} from "@angular/material/typings/toolbar";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    UserComponent,
    LecturerComponent,
    AdminComponent,
    UserListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule

  ],
  providers: [ɵHttpInterceptingHandler],
  bootstrap: [AppComponent]
})
export class AppModule { }
