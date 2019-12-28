import { Component, OnInit } from '@angular/core';
import {CourseService} from "../services/course.service";

import {Course} from "./course";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  // board: string;
  // errorMessage: string;

  courses:Array<any>;

  constructor(private courseService:CourseService) { }

  ngOnInit() {
    this.courseService.getAll().subscribe(data=>{
      this.courses=data;
    })
  }

}

