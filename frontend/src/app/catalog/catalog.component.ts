import { Component, OnInit } from '@angular/core';
import {MycourseService} from "../shared/mycourse/mycourse.service";

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  mycourses: Array<any>;
  keywords;
  constructor(private myCourseService: MycourseService) { }

  ngOnInit() {
    this.myCourseService.getAll().subscribe((data)=>{
      this.mycourses=data;
    })

  }
  search() {

  }
  filter(){}

}
