import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {beforeEach} from "selenium-webdriver/testing";
import {toArray} from "rxjs/operators";
import {MyCourse} from "./mycourse";

@Injectable({
  providedIn: 'root'
})
export class MycourseService {
  private courseUrl = 'http://localhost:8080/courses/list';
  private baseUrl = 'http://localhost:8080/courses/';
  private saveUrl = 'http://localhost:8080/courses/save';
  private updateUrl = 'http://localhost:8080/courses/update/';

  keyword:string;
  courses: MyCourse[];
  mycourse: MyCourse;


  constructor(private http: HttpClient) { }

  getAll():Observable<any>{
    return this.http.get(this.courseUrl);
  }
  get (id: string){
    return this.http.get(this.baseUrl + id);
  }
  save(mycourse:any): Observable<any> {
    let result: Observable<any>;
    if(mycourse.href){
      result = this.http.put(mycourse.href, mycourse);
    }else {
      result = this.http.post(this.saveUrl,mycourse);
    }
    return result;
  }

  update(mycourse,id): Observable<any> {
    return this.http.put('http://localhost:8080/courses/update/'+ id,mycourse);

  }
  remove(id){
    return this.http.delete("http://localhost:8080/courses/cancel/"+id);
  }

  // search(keyword):Observable<any>{
  //   let word:string;
  //
  //   let word_array:Observable<any>;
  //   word_array=this.getAll();
  //   let filtered_array: [];
  //     let n:number;
  //
  //   }

    // titleSearch(keywords:string): MyCourse []{
    // let courses = this.getAll();
    // courses.filter(mycourse => this.isMatching(mycourse,keywords));
    //
    //
    // return courses;
    //
    // }


}
