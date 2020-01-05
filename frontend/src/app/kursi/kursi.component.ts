import { Component, OnInit } from '@angular/core';

import {KursService} from  './shared/kurs.service'
import {Kurs} from "./shared/kurs.model";
@Component({
  selector: 'app-kursi',
  templateUrl: './kursi.component.html',
  styleUrls: ['./kursi.component.css'],
  providers:[KursService]
})
export class KursiComponent implements OnInit {

  id:number;
  kurs: Kurs;

  constructor(private kursService : KursService) { }


  ngOnInit() {
  }

}
