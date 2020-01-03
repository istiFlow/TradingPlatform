import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  email = 'email'
  password = ''
  invalidLogin = false
  errorMessage = "Invalid login"

  handleLogin() {
    if(this.email==="vajgi90@gmail.com" && this.password === 'pass') {
      this.router.navigate(['stocks'])
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
  }
}
