import {Component, Input, OnInit} from '@angular/core';
import {MyCourse} from "../../shared/mycourse/mycourse";

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {

  @Input()
  public mycourse:MyCourse;
  constructor() { }

  ngOnInit() {
  }

}
