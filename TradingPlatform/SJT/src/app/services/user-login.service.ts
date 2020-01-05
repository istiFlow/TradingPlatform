import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Auth } from '../auth';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  auth: Auth;

  constructor(private http: HttpClient) { }

  public getUserByEmail(email, password) {
    return this.http.get("http://localhost:8080/user/"+email+"&"+password);
  }

  public getUserByEmai2(email, password) {
    const headers = new HttpHeaders ({Authorization: 'Basic ' + btoa(email + ':' + password)});
    return this.http.get("http://localhost:8080/user/login", {headers}).pipe(
      map(
        userData => {
         sessionStorage.setItem('email',email);
         return userData;
        }
      )
 
     );
  }
}
