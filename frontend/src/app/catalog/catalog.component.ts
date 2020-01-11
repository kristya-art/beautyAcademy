import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MycourseService} from "../shared/mycourse/mycourse.service";
import {toArray} from "rxjs/operators";
import {MyCourse} from "../shared/mycourse/mycourse";

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  mycourses: Array<any>;
  keywords : string;
  searchedList:any;
  list:any;
  selectedCourse: MyCourse;
  words: Array<any>;
  // mycourse: MyCourse;


  constructor(private myCourseService: MycourseService) { }

  ngOnInit() {
    this.myCourseService.getAll().subscribe((data)=>{
      this.mycourses=data;
    })

  }
  onSelect(mycourse: MyCourse):void {
    this.selectedCourse =mycourse;
  }




}
