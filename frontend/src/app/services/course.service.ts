import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Course} from "../course/course";


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courseUrl = 'http://localhost:8080/courses/list';

  constructor(private http : HttpClient) {}

    getAll() : Observable<any> {
      return this.http.get(this.courseUrl,{responseType: 'json'});
    }


}
