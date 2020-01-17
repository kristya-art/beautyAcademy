import { NgModule } from '@angular/core';
import { RouterModule , Routes} from '@angular/router';

import {RegisterComponent} from "../register/register.component";
import {LoginComponent} from "../login/login.component";
import { HomeComponent } from "../home/home.component";
import { UserComponent } from '../user/user.component';
import { LecturerComponent } from '../lecturer/lecturer.component';
import { AdminComponent } from '../admin/admin.component';
import {UserListComponent} from "../user-list/user-list.component";
import {CourseComponent} from "../course/course.component";
import {SubscriptionComponent} from "../subscription/subscription.component";
import {KursiComponent} from "../kursi/kursi.component";
import {MycourseService} from "../shared/mycourse/mycourse.service";
import {MycourseListComponent} from "../mycourse-list/mycourse-list.component";
import {MycourseEditComponent} from "../mycourse-list/mycourse-edit/mycourse-edit.component";
import {CatalogComponent} from "../catalog/catalog.component";
import {CourseDetailsComponent} from "../catalog/course-details/course-details.component";

const routes: Routes = [

  {
    path: 'home',
    component: HomeComponent
  } ,
  {
    path: 'catalog',
    component: CatalogComponent
  },
  {
    path: 'course-details',
    component: CourseDetailsComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  // {
  //   path: 'course',
  //   component: CourseComponent
  //
  // },
  {
    path: 'subscription',
    component: SubscriptionComponent
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
  {
    path: 'subscription',
    component: SubscriptionComponent
  },
  // {
  //   path: 'kursi',
  //   component: KursiComponent
  // },

  // {
  //   path: 'course-list',
  //   component: CourseComponent
  //
  // },

  // {path: '',redirectTo: '/mycourse-list',pathMatch:'full'},
  {
    path : 'mycourse-list',
    component: MycourseListComponent
  },
  {
    path : "mycourse-add",
    component: MycourseEditComponent
  },
  {
    path: 'mycourse-edit/:id',
    component:MycourseEditComponent
  },
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
