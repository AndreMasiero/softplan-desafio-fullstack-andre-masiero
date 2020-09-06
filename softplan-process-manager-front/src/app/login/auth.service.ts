import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import {API_CONFIG} from '../config/api.config';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

  constructor(private http: HttpClient) {

  }

  authenticationService(email: string, password: string) {
    return this.http.post<string>(`${API_CONFIG.baseUrl}/login`, {email: email, password: password}, {observe: 'response'});
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === null) {
      return false;
    }
    return true;
  }
}
