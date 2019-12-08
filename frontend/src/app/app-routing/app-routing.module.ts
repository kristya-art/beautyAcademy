import { NgModule } from '@angular/core';
import { RouterModule , Routes} from '@angular/router';

import {RegisterComponent} from "../register/register.component";
import {LoginComponent} from "../login/login.component";
import { HomeComponent } from "../home/home.component";
import { UserComponent } from '../user/user.component';
import { LecturerComponent } from '../lecturer/lecturer.component';
import { AdminComponent } from '../admin/admin.component';
import {UserListComponent} from "../user-list/user-list.component";

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  } ,
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'lecturer',
    component: LecturerComponent
  },
  {
    path: 'admin',
    component: AdminComponent

  },
  {
    path: 'auth/login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: RegisterComponent
  },
  {
    path: 'user-list',
    component: UserListComponent
  },
  // {
  //   path: 'course-list',
  //   component: CourseComponent
  //
  // },

  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
