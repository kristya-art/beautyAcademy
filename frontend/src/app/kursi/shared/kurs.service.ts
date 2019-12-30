import { Injectable } from '@angular/core';

import {Kurs} from'./kurs.model'
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class KursService {

  private courseUrl = 'http://localhost:8080/courses/list';
  private baseUrl = 'http://localhost:8080/courses/';
 // selectedKurs: Kurs = new Kurs(null,"","","",null,[]);
 selectedKurs : Kurs;
  id:number;


  constructor(private http: HttpClient) { }

  // postKurs(kurs : Kurs) {
  //   var body = JSON.stringify(kurs);
  //   var headerOptions = new Headers({'Content-Type':'application/json'});
  //   var requestOptions = new Request({method : requestMethod.POST,headers : headerOptions});
  //   this.http.post('url',body,requestOptions)
  //   }
  getAll() : Observable<any> {
    return this.http.get(this.courseUrl,{responseType: 'json'});
  }


  updateKurs(id: number, value: any): Observable<Object> {
    return this.http.put("http://localhost:8080/courses/update/" + id,value);
  }

 createKurs(kurs:Object):Observable<Object> {
    return this.http.post("http://localhost:8080/courses/create/",kurs);
 }

 getKurs(id: number):Observable<any> {
    return this.http.get("http://localhost:8080/courses/" + id);
 }
  deleteKurs(id){
    return this.http.delete("http://localhost:8080/courses/cancel/"+id);
  }


}
