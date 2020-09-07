import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../login/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {UserAuthorizationService} from '../services/UserAuthorizationService';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  userAuthorization: UserAuthorizationService;

  isLoggedIn = false;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    this.userAuthorization = new UserAuthorizationService();
  }

  logout() {
    localStorage.removeItem('localUser');
    this.router.navigateByUrl('login');
  }

  user() {
    this.router.navigateByUrl('user');
  }

  process() {
    this.router.navigateByUrl('process');
  }

}
