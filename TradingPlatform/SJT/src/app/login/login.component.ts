import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {





  constructor(private router: Router, 
    private service: AuthService) { }

  ngOnInit() {
  }

  userLoginData = {};
  temp: any;
  invalidLogin = false
  validLogin = false;
  output: string;
  showSpinner = false;

  handleLogin() {
    this.loadData();
    let resp = this.service.getUser(this.userLoginData);
    resp.subscribe((data) => this.temp = data);
    this.output = Object.values(this.temp).toString();
    if(this.output == "OK") {
      this.service.onSwitchLoggedIn();
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
  loadData() {
    this.showSpinner = true;
    setTimeout(() => {
        this.showSpinner = false;
    }, 3000)
  }
}


