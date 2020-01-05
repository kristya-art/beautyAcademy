import { BrowserModule } from '@angular/platform-browser';


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

import { SubscriptionComponent } from './subscription/subscription.component';
import { SearchDeleteComponent } from './search-delete/search-delete.component';
import { CourseComponent } from './course/course.component';
import { KursiComponent } from './kursi/kursi.component';
import { KursComponent } from './kursi/kurs/kurs.component';
import { KursListComponent } from './kursi/kurs-list/kurs-list.component';
import { MycourseListComponent } from './mycourse-list/mycourse-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatCardModule,
  MatFormField,
  MatFormFieldModule,
  MatInputModule,
  MatToolbarModule
} from "@angular/material";
import {MatListModule} from "@angular/material";
import { MycourseEditComponent } from './mycourse-list/mycourse-edit/mycourse-edit.component';
import { CatalogComponent } from './catalog/catalog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    UserComponent,
    LecturerComponent,
    AdminComponent,
    UserListComponent,
    SubscriptionComponent,
    SearchDeleteComponent,
    CourseComponent,
    KursiComponent,
    KursComponent,
    KursListComponent,
    MycourseListComponent,
    MycourseEditComponent,
    CatalogComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatToolbarModule,
    MatListModule,
    MatFormFieldModule,
    MatInputModule,






  ],
  exports:[
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [ɵHttpInterceptingHandler],
  bootstrap: [AppComponent]
})
export class AppModule { }
