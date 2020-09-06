import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {AuthenticationService} from './login/auth.service';
import {API_CONFIG} from './config/api.config';
import {StorageService} from './services/storage.service';

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {

  constructor(public storage: StorageService, private authenticationService: AuthenticationService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const localUser = this.storage.getLocalUser();

    const N = API_CONFIG.baseUrl.length;
    const requestToAPI = req.url.substring(0, N) === API_CONFIG.baseUrl;

    if (localUser && requestToAPI) {
      const authReq = req.clone({headers: req.headers.set('Authorization', '' + localUser)});
      return next.handle(authReq);
    } else {
      return next.handle(req);
    }
  }
}