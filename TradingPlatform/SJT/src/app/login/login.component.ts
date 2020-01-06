import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {User} from '../user'
import { UserLoginService } from '../services/user-login.service';
import { Auth } from '../auth';
import { from } from 'rxjs';

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

  email: string;
  password: string;
  temp: any;
  invalidLogin = false
  validLogin = false;
  user: User = new User("","");
  result: string[];
  output: string;

  handleLogin() {
    if(this.email==="vajgi90@gmail.com" && this.password === 'pass') {
      this.router.navigate(['stocks'])
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }
  }

  handleLogin2() {
    let resp = this.service.getUser(this.user);
    resp.subscribe((data) => this.temp = data);
    this.output = Object.values(this.temp).toString();
    if(this.output == "OK") {
      this.router.navigate(['stocks']);
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }
  }
  public spliter(item: string): string[] {
    let arr = item.split(",");
      return arr;
  }
}


