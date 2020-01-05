import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private subscriptionUrl = 'http://localhost:8080/subscriptions/list';

  constructor(private http: HttpClient) {}
    getAll() : Observable<any> {
    return this.http.get(this.subscriptionUrl, {responseType: 'json'});
    }

}
