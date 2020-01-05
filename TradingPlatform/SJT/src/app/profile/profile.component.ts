import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserLoginService } from '../services/user-login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private router: Router, 
    private service: UserLoginService) { }

  ngOnInit() {
  }

  id : number;
  email = '';
  password = '';
  isDownload = false;
  temp: any;
  result: string[];
  output: string;

  handleProfile() {
    let resp = this.service.getUserByEmail(this.email);
    resp.subscribe((data) => this.temp = data);
    this.isDownload = true;
    this.output = Object.values(this.temp).toString();
    this.result = this.spliter(this.output)
    this.id = parseInt(this.result[0]);
    this.email = this.result[1];
    this.password = this.result[2];
  }

  deleteProfile() {
    let resp = this.service.deleteUserByEmail(this.email);
  }

  public spliter(item: string): string[] {
    let arr = item.split(",");
      return arr;
  }




}
