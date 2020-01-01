import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {resolveSanitizationFn} from "@angular/compiler/src/render3/view/template";

@Injectable({
  providedIn: 'root'
})
export class MycourseService {
  private courseUrl = 'http://localhost:8080/courses/list';
  private baseUrl = 'http://localhost:8080/courses/';
  private saveUrl = 'http://localhost:8080/courses/save';

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
  remove(href: string) {
    return this.http.delete(href);
  }
}
