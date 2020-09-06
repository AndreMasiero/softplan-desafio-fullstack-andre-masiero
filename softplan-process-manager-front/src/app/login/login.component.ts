import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {HttpResponse} from '@angular/common/http';
import {AuthenticationService} from './auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  errorMessage = 'Credenciais inválidas';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
  }

  login() {
    this.authenticationService.authenticationService(this.email, this.password).subscribe((res: HttpResponse<any>) => {
      localStorage.setItem('localUser', JSON.stringify(res.headers.get('Authorization')));
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Logado com sucesso.';
      this.router.navigate(['/user']);
    }, (error) => {
      console.log(error)
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }

}
