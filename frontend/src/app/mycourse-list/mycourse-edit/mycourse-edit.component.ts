import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {MycourseService} from "../../shared/mycourse/mycourse.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-mycourse-edit',
  templateUrl: './mycourse-edit.component.html',
  styleUrls: ['./mycourse-edit.component.css']
})
export class MycourseEditComponent implements OnInit {

  mycourse: any = {};
  sub :Subscription;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private mycourseService: MycourseService
              ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params=>{
      const id = params.id;
      if(id ){
        this.mycourseService.get(id).subscribe((mycourse:any)=>{
          if(mycourse){
            this.mycourse = mycourse;
            this.mycourse.href = mycourse._links.self.href;
            this.mycourseService.get(mycourse.id).subscribe(url => mycourse.Url = url);

          }else{
            console.log(`Course with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }
ngOnDestroy(){
    this.sub.unsubscribe();
}
gotoList() {
    this.router.navigate(['/mycourse-list'])
}


save(form: NgForm){
    this.mycourseService.save(form).subscribe(result=>{
      this.gotoList();
    },error => console.error(error));
}
remove(href) {
    this.mycourseService.remove(href).subscribe(result=>
    {this.gotoList();},
    error => console.error(error))}

  update(mycourse,href){
    this.mycourseService.update(mycourse,href).subscribe(result=>{
      this.gotoList();
    },error => console.error(error));
  }

}

