import { Component, OnInit } from '@angular/core';
import {CourseService} from "../services/course.service";

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent implements OnInit {
  courses:any;
  constructor(private service:CourseService) { }


  ngOnInit() {
    let resp = this.service.getAll();
    resp.subscribe((data)=>this.courses=data);
  }

}
