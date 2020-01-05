import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {User} from '../user'
import { UserRegistrationService } from '../services/user-registration.service';
import { UserLoginService } from '../services/user-login.service';
import { Auth } from '../auth';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  constructor(private router: Router, 
    private service: UserLoginService) { }

  ngOnInit() {
  }

  email = ''
  password = ''
  invalidLogin = false
  user: User = new User('','');
  result: Object;
  output;

  handleLogin() {
    if(this.email==="vajgi90@gmail.com" && this.password === 'pass') {
      this.router.navigate(['stocks'])
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }
  }

  handleLogin2() {
    let resp = this.service.getUserByEmail(this.email, this.password);
    resp.subscribe((data) => this.result = data);
    this.output = Object.values(this.result).toString();
    if(this.output == "OK") {
      this.router.navigate(['stocks'])
      this.invalidLogin = false; 
    } {
      this.invalidLogin = true;
    }
  }

  handleRegistration() {
    this.router.navigate(['register'])
  }
}


