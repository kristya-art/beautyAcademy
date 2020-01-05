import { Component, OnInit } from '@angular/core';
import {MycourseService} from "../shared/mycourse/mycourse.service";

@Component({
  selector: 'app-mycourse-list',
  templateUrl: './mycourse-list.component.html',
  styleUrls: ['./mycourse-list.component.css']
})
export class MycourseListComponent implements OnInit {

  mycourses: Array<any>;
  constructor(private myCourseService:MycourseService) { }

  ngOnInit() {
    this.myCourseService.getAll().subscribe((data)=>{
      this.mycourses=data;
    })
  }

}
