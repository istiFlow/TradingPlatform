import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Auth } from '../auth';
import { map, catchError } from 'rxjs/operators';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  auth: Auth;
  user: User;
  item: any;

  constructor(private http: HttpClient) { }

  public getUser (user: Object): Observable<Object> {
    return this.http.post("http://localhost:8080/user/login", user, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
  }

  public getUserByEmail(email: string) {
    return this.http.get("http://localhost:8080/user/"+email);
  }

  public deleteUserByEmail(email: string): Observable<void> {
    return this.http.delete<void>("http://localhost:8080/user/"+email);
    //.pipe(catchError(this.handleError))
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
