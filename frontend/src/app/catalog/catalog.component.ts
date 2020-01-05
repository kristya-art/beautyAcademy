import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MycourseService} from "../shared/mycourse/mycourse.service";
import {toArray} from "rxjs/operators";

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  mycourses: Array<any>;
  keywords;
  searchedList:any;
  list:any;


  constructor(private myCourseService: MycourseService) { }

  ngOnInit() {
    this.myCourseService.getAll().subscribe((data)=>{
      this.mycourses=data;
    })

  }


}
