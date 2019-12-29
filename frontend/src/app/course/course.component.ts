import { Component, OnInit } from '@angular/core';
import {CourseService} from "../services/course.service";

import {Course} from "./course";
import {Observable} from "rxjs";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  // board: string;
  // errorMessage: string;

 // courses:Array<Course>;
  message:string;
  courses:any;
  course:Course = new Course(0,"","","",0);
  constructor(private courseService:CourseService) { }

  ngOnInit() {
    this.courseService.getAll().subscribe(data=>{
      this.courses=data;
    // this.reloadData();
    })
  }
 reloadData() {
    this.courses = this.courseService.getAll();
 }

 deleteCourse(id:number){
    let resp = this.courseService.deleteCourse(id);
    resp.subscribe((data)=>this.courses=data);
   // this.reloadData();
 }



 // addCourse():void{
 //    this.courseService.addCourse(this.course)
 //      .subscribe((response)=>
 //      {console.log(response)},(error)=>{
 //        console.log(error);
 //      })
 // }






 // deleteCourse(id:number){
 //    this.courseService.deleteCourse(id).subscribe(data=>{
 //        console.log(data);
 //        this.reloadData();
 //      },
 //        error => console.log(error)
 //        );
 // }
}

