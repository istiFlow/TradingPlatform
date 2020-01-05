import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http: HttpClient) { }


/*   public doRegistration(user) {
    return this.http.post("http://localhost:8080/register",user,{responseType: 'text' as 'json'})
  } */

  createUser(user: Object): Observable<Object> {
    return this.http.post("http://localhost:8080/register", user);
  }
}
