import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _registerUrl = "http://localhost:8080/register";
  private _loginUrl = "http://localhost:8080/user/login";

  public isLoggedIn = false;

  item: any;

  onSwitchLoggedIn() {
    this.isLoggedIn = !this.loggedIn;
  }

  loggedIn() {
    return this.isLoggedIn;
  }



  constructor(private http: HttpClient) { }


  public getUser (user: Object): Observable<Object> {
    return this.http.post<any>(this._loginUrl, user, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
  }

  registerUser(user: Object):Observable<Object> {
    return this.http.post<any>(this._registerUrl, user);
  }

  public getUserByEmail(email: string) {
    return this.http.get("http://localhost:8080/user/"+email);
  }

  public updateUserPassword(userUpdate: any): Observable<any> {
    return this.http.put("http://localhost:8080/user", userUpdate)
      
  }

  public deleteUserByEmail(email: string): Observable<void> {
    return this.http.delete<void>("http://localhost:8080/user/"+email);
  }

}


