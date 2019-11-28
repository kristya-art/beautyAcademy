import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "./auth/token-storage-service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  private roles: string[];
  private authority: string;

  title = 'BEA';
  message = ' Welcome to the beautiful academy!';
  quote = 'Beauty begins the moment you decide to be yourself. Coco Chanel';

  constructor(private tokenStorage: TokenStorageService ) {

  }
  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role ==='ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_LECTURER') {
          this.authority = 'lecturer';
          return false;
        }
        this.authority = 'user';
      });
    }
  }
}
