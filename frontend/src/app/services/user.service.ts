import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import { Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8080/api/test/user';
  private lecturerUrl = 'http://localhost:8080/api/test/lecturer';
  private adminUrl = 'http://localhost:8080/api/test/admin';
  private usersUrl = 'http://localhost:8080/users/list';

  constructor(private http: HttpClient) { }

  getUserBoard(): Observable<string>{
    return this.http.get(this.userUrl, {responseType: 'text'});
  }

  getLecturerBoard(): Observable<string>{
    return this.http.get(this.lecturerUrl, {responseType: 'text'});
  }

  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, {responseType: 'text'});
  }

  getAll():Observable<any> {
    return this.http.get(this.usersUrl,{responseType: 'json'});
  }
}
