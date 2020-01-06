import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-not-found',
  template: `
  <body style="background:#89bee2; width: 100%; height: 565px;">

   <h3 style="text-align:center; padding-top: 50px; color:#525252">Page Not Found</h3> 

   <button routerLink="/login" style="  background:#2ecc71;
   width:125px;
   padding-top:5px;
   padding-bottom:5px;
   color:white;
   border-radius:4px;
   border: #27ae60 1px solid;
   
   margin-bottom:20px;
   float:left;
   margin-left:45%;
   font-weight:800;
   font-size:0.8em;">Back to login</button>

  </body>
   `,
  styles: []
})
export class PageNotFoundComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
