import { Component, OnInit } from '@angular/core';
import {KursService} from '../shared/kurs.service'
import {NgForm} from "@angular/forms";
import {subscribeOn} from "rxjs/operators";
import {Kurs} from "../shared/kurs.model";
import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-kurs',
  templateUrl: './kurs.component.html',
  styleUrls: ['./kurs.component.css']
})
export class KursComponent implements OnInit {

  form: any = {};
  selectedKurs: Kurs;
  submited = false;
  errorMessage= '';
  id:number;
  // id:number;
  // kurs:Kurs;
  // kursi : any;
  // selectedKurs:Kurs = new Kurs(0,"","","",0,[]);
  // submitted = false;
   constructor(private route: ActivatedRoute,private router: Router,private kursService:KursService) { }
  //
  // ngOnInit() {
  //   this.resetForm();
  //
  //  // this.kurs = new Kurs(null,"","","",null,[]);
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
  //   //this.kurs = new Kurs(null,"","","",null,[]);
  //   this.gotoList();
  // }

  // onSubmit(form:NgForm) {
  //   this.submitted = true;
  //   this.updateKurs();
  //
  //   this.resetForm(form)
  // }

  // onSubmit(form:NgForm){
  //   this.updateKurs(form.value);
 //   .subcribe(data=>{
 //     this.resetForm(form);
//})
  //
  // }
  // gotoList() {
  //   this.router.navigate(['/courses']);
  // }

  ngOnInit(){
  }

  onSubmit(){
     console.log(this.form);

     this.selectedKurs = new Kurs(
       this.form.id,
       this.form.code,
         this.form.title,
       this.form.description,
       this.form.points,
       this.form.topics
     ) ;

     this.kursService.updateKurs(this.id,this.selectedKurs).subscribe(
       data=>{
         console.log(data);
         this.submited=true;
         this.resetForm(this.form);
       },
       error=>{
         console.log(error);
         this.errorMessage = error.error.message;
       }
     )

  }
  resetForm(form?: NgForm){
    if(form !=null)
      form.reset();
    this.kursService.selectedKurs = {
      id : null,
      code: "",
      title: "",
      points: null,
      description: "",

    }
  }
}
