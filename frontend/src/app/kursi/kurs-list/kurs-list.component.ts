import { Component, OnInit } from '@angular/core';
import {KursService} from '../shared/kurs.service'
import {Kurs} from "../shared/kurs.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-kurs-list',
  templateUrl: './kurs-list.component.html',
  styleUrls: ['./kurs-list.component.css']
})
export class KursListComponent implements OnInit {

  id:number;
  kurs:Kurs;

  constructor(private route: ActivatedRoute,private router: Router,private kursService:KursService) { }

  ngOnInit() {
    this.kurs = new Kurs(null,"","","",null,[]);

    this.kursService.getKurs(this.id)
      .subscribe(data=>{
        console.log(data);
        this.kurs = data;
      },error => console.log(error));
  }
  updateKurs() {
    this.kursService.updateKurs(this.id, this.kurs)
      .subscribe(data => console.log(data), error => console.log(error));
    this.kurs = new Kurs(null,"","","",null,[]);
    this.gotoList();
  }

  onSubmit() {
    this.updateKurs();
  }
  gotoList() {
    this.router.navigate(['/courses']);
  }
}
