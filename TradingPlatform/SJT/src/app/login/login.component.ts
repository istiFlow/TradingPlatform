import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {User} from '../user'
import { UserRegistrationService } from '../services/user-registration.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  constructor(private router: Router, 
    private service: UserRegistrationService) { }

  ngOnInit() {
  }

  email = ''
  password = ''
  invalidLogin = false
  errorMessage = "Invalid data"
  user: User = new User('','');
  message: any;

  handleLogin() {
    if(this.email==="vajgi90@gmail.com" && this.password === 'pass') {
      this.router.navigate(['stocks'])
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
  }

  handleRegister() {
      let response = this.service.doRegistration(this.user);
      response.subscribe((data) => this.message=data);
  } 

  handleRegister2() {
  this.service.createUser(this.user).subscribe(data => {
    this.message = data;
  });
}

  handleRegistration() {
    this.router.navigate(['register'])
  }
}


