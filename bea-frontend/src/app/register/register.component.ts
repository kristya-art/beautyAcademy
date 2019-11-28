import { Component, OnInit } from '@angular/core';
import{AuthService} from "../auth/auth.service";
import{SignUpInfo} from "../auth/signup-info";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  signupInfo:SignUpInfo;
  isSignedUp = false;
  isSignedUpFailed = false;
  errorMessage = '';

  constructor(private authService) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignUpInfo(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.role,
      this.form.password);

     this.authService.signUp(this.signupInfo).subscribe(
       data=> {
         console.log(data);
         this.isSignedUp=true;
         this.isSignedUpFailed=false;
       },

       error=>{
         console.log(error);
         this.errorMessage = error.error.message;
         this.isSignedUpFailed=true;
       }
     );

  }

}
