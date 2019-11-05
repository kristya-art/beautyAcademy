import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service'

@Component({
  selector: 'app-lecturer',
  templateUrl: './lecturer.component.html',
  styleUrls: ['./lecturer.component.css']
})
export class LecturerComponent implements OnInit {
  board: string;
  errorMessage: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getAdminBoard().subscribe(
      data=> {
        this.board = data;
      },
      error=> {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }

}
