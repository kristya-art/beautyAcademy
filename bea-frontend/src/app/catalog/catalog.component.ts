import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-catalog',
  template: `
  <h1>{{title}}</h1>
    <h2>Our catalog of courses: </h2>
    <p></p>
    <ul>
      <li *ngFor="let course of courses">
        {{course}}
      </li>
    </ul>
  
  `,
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent  {

 title = "Catalog of courses";
 courses = ['beautiful-person course', 'instructor-of-beauty course'];

  selected = false;

 selectBook(){
   return this.selected=true;
 }



}
