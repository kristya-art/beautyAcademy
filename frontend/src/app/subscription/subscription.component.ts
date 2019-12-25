import { Component, OnInit } from '@angular/core';
import {SubscriptionService} from "../services/subscription.service";

@Component({
  selector: 'app-subscription',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.css']
})
export class SubscriptionComponent implements OnInit {

  subscriptions: Array<any>;

  constructor(private subscriptionService: SubscriptionService) { }

  ngOnInit() {

    this.subscriptionService.getAll().subscribe(data=>{
      this.subscriptions = data;
    })
  }

}
