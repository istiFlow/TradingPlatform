import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {User} from '../user'
import { UserRegistrationService } from '../services/user-registration.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  email = ''
  password = ''
  invalidLogin = false
  errorMessage = "Invalid data"
  user: User = new User('','');
  message: any;

  constructor(private router: Router,
    private service: UserRegistrationService) { }

  ngOnInit() {

  }

  handleRegister2() {
    let resp = this.service.createUser(this.user);
    resp.subscribe(data => {
      this.message = data;
    });
  }
}
