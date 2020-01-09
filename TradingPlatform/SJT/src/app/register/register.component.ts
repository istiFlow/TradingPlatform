import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerUserData = {};
  validReg = false;

  constructor(private router: Router,
    private service: AuthService) { }

  ngOnInit() {

  }
  handleRegister() {
    this.service.registerUser(this.registerUserData)
    .subscribe(
      res => console.log(res),
      err => console.log(err)
    );
    this.validReg = true;
    this.router.navigate(['login']);
  }
}
