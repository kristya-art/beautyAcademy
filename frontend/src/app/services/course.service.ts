import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Course} from "../course/course";


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courseUrl = 'http://localhost:8080/courses/list';
  private baseUrl = 'http://localhost:8080/courses/';

  constructor(private http : HttpClient) {}

    getAll() : Observable<any> {
      return this.http.get(this.courseUrl,{responseType: 'json'});
    }




   getCourseById(id){
    return this.http.get(this.baseUrl+id);
   }

   deleteCourse(id){
    return this.http.delete("http://localhost:8080/courses/cancel/"+id);
   }


   addCourse(couse:Course){

   }

  updateCourse (course,id): Observable<any> {
    return this.http.put(this.baseUrl+ id,course );

  }



  // get


  // addCourse(course:Course){
  //   let body = JSON.stringify(course);
  //   return this.http.post(this.courseUrl,body);
  //
  // }







  // deleteCourse(id: number): Observable<any> {
  //   return this.http.delete(`${this.courseUrl}/${id}`, { responseType: 'text' });
  // }
  // createCourse(course: Object): Observable<Object> {
  //   return this.http.post(`${this.courseUrl}`, course);
  // }
  //
  // updateCourse(id: number, value: any): Observable<Object> {
  //   return this.http.put(`${this.courseUrl}/${id}`, value);
  // }
}
