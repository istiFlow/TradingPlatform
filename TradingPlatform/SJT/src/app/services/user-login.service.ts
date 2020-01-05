import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Auth } from '../auth';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  auth: Auth;

  constructor(private http: HttpClient) { }

  public getUserByEmailAndPassword(email, password) {
    return this.http.get("http://localhost:8080/login/"+email+"/"+password);
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
