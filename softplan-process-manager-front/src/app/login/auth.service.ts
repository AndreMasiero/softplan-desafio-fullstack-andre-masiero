import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import {API_CONFIG} from '../config/api.config';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

  public username: string;
  public password: string;

  constructor(private http: HttpClient) {

  }

  authenticationService(email: string, password: string) {
    return this.http.post<string>(`${API_CONFIG.baseUrl}/login`, {email: email, password: password}, {observe: 'response'});
  }

  // authenticationService(username: string, password: string) {
  //   return this.http.get(`http://localhost:8080/login`,
  //     { headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
  //       this.username = username;
  //       this.password = password;
  //       this.registerSuccessfulLogin(username, password);
  //     }));
  // }

  createBasicAuthToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ':' + password);
  }

  registerSuccessfulLogin(username, password) {

    // sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === null) {
      return false;
    }
    return true;
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === null) {
      return '';
    }
    return user;
  }
}
