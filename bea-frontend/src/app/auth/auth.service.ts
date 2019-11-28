import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import { AuthLoginInfo } from './login-info';
import { SignUpInfo } from './signup-info'
import {Injectable} from "@angular/core";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})

};
@Injectable({
  providedIn: "root"
})
export class AuthService {

  private loginUrl = 'http://localhost:8080/api/auth/signin';
  private signupUrl = 'http://localhost:8080/api/auth/signup';

  constructor(private http: HttpClient) {}

  signUp(info: SignUpInfo):Observable<string> {
    return this.http.post<string>(this.signupUrl, info, httpOptions);
  }
}