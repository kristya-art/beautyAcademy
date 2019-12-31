import { Component, OnInit } from '@angular/core';
import {KursService} from '../shared/kurs.service'
import {Kurs} from "../shared/kurs.model";

@Component({
  selector: 'app-kurs-list',
  templateUrl: './kurs-list.component.html',
  styleUrls: ['./kurs-list.component.css']
})
export class KursListComponent implements OnInit {

  message:string;
  kursi:any
  id:number
  kurs:Kurs = new Kurs(0,"","","",0, []);
  constructor(private kursService:KursService) { }

  ngOnInit() {
    this.kursService.getAll().subscribe(data=>{
      this.kursi=data;
      // this.reloadData();
    })
  }
  reloadData() {
    this.kursi = this.kursService.getAll();
  }

  deleteKurs(id:number){
    let resp = this.kursService.deleteKurs(id);
    resp.subscribe((data)=>this.kursi=data);
    // this.reloadData();
  }
  update(id): void {
    this.kursService.updateKurs(this.id,this.kurs)
      .subscribe(() => this.message = "Customer Updated Successfully!");
   // console.log('http://localhost:8080/courses/update/'+ this.id);
  }





  // ngOnInit() {
  //   this.kurs = new Kurs(null,"","","",null,[]);
  //
  //   this.kursService.getKurs(this.id)
  //     .subscribe(data=>{
  //       console.log(data);
  //       this.kurs = data;
  //     },error => console.log(error));
  // }
  // updateKurs() {
  //   this.kursService.updateKurs(this.id, this.kurs)
  //     .subscribe(data => console.log(data), error => console.log(error));
  //   this.kurs = new Kurs(null,"","","",null,[]);
  //   this.gotoList();
  // }
  //
  // onSubmit() {
  //   this.updateKurs();
  // }
  // gotoList() {
  //   this.router.navigate(['/courses']);
  // }
  //
  // deleteKurs(id){
  //   this.kursService.deleteKurs(id);
  // }
}
