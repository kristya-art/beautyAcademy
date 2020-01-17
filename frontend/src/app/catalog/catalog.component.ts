import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MycourseService} from "../shared/mycourse/mycourse.service";
import {toArray} from "rxjs/operators";
import {MyCourse} from "../shared/mycourse/mycourse";
import {element} from "protractor";

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
  words: Array<String>;
  pageName: string = "Catalog of courses";

  constructor(private myCourseService: MycourseService) { }

  ngOnInit() {
    this.myCourseService.getAll().subscribe((data)=>{
      this.mycourses=data;
    })

  }
  onSelect(mycourse: MyCourse):void {
    this.selectedCourse =mycourse;
  }

 // searchCourse(keywords:string): MyCourse[]{
 //
 // }

 // toArray(): MyCourse[] {
 //   this.myCourseService.getAll()
 //     .subscribe(res=>this.mycourses = res as Array<String>);
 //
 //   return this.list;
 // }
  filtering(keywords){
    this.words = [];
   for(let o of this.mycourses){
     for(let m of o.getTitle())
      if(m.includes(keywords)){
        this.words.push(m);

      }
   }
  }



}
