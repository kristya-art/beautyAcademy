import {Component, Input, OnInit, Output} from '@angular/core';
import {MyCourse} from "../../shared/mycourse/mycourse";
import {EventEmitter} from "events";

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {

  @Input()
  public mycourse:MyCourse;

  @Output()
  public back = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

}
