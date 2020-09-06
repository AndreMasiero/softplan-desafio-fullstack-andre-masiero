import {Component, Injector, OnInit} from '@angular/core';
import {UserService} from '../user.service';
import {UserInputDto} from '../_model/user-input-dto';
import {ActivatedRoute, Router} from '@angular/router';

interface Roles {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-user-new',
  templateUrl: './user-new.component.html',
  styleUrls: ['./user-new.component.css']
})
export class UserNewComponent implements OnInit {

  userInputDto: UserInputDto;

  password: string;
  confirmPassword: string;

  protected router: Router;
  protected activatedRoute: ActivatedRoute;

  errorMessage: string;

  isEditing: number;

  roles: Roles[] = [
    {value: 'ROLE_ADMIN', viewValue: 'Administrador'},
    {value: 'ROLE_TRIATOR', viewValue: 'Triador'},
    {value: 'ROLE_FINISHER', viewValue: 'Finalizador'}
  ];

  constructor(protected injector: Injector, private userService: UserService) {
    this.router = injector.get(Router);
    this.activatedRoute = injector.get(ActivatedRoute);
  }

  ngOnInit() {
    this.isEditing = this.activatedRoute.snapshot.params.id;
    this.userInputDto = new UserInputDto();

    if (this.isEditing) {
      this.getUser(this.isEditing);
    }
  }

  getUser(id: number) {
    this.userService.getUser(id).subscribe((result => {
      this.userInputDto = result;
    }), error => {
      this.errorMessage = 'Não foi possível recuperar o usuário.';
    });
  }

  saveOrUpdate() {
    if (this.formValidate() === false) {
      return;
    }

    if (this.isEditing) {
      this.update(this.isEditing);
    } else {
      this.save();
    }
  }

  save() {
    this.errorMessage = null;
    this.userService.save(this.userInputDto).subscribe(() => {
      this.router.navigateByUrl('/user');
    }, error => {
      this.errorMessage = error['error']['message'];
    });
  }

  update(id: number) {
    this.errorMessage = null;
    this.userService.update(this.userInputDto, id).subscribe(() => {
      this.router.navigateByUrl('/user');
    }, error => {
      this.errorMessage = error['error']['message'];
    });
  }

  formValidate(): boolean {
    this.errorMessage = null;
    if (this.userInputDto.firstName === null || this.userInputDto.firstName === '') {
      this.errorMessage = 'Nome não pode ser vazio';
      return false;
    }
    if (this.userInputDto.firstName.length < 3 || this.userInputDto.firstName.length > 20) {
      this.errorMessage = 'Nome deve conter entre 3 e 20 caracteres';
      return false;
    }
    if (this.userInputDto.lastName === null || this.userInputDto.lastName === '') {
      this.errorMessage = 'Nome não pode ser vazio';
      return false;
    }
    if (this.userInputDto.lastName.length < 3 || this.userInputDto.lastName.length > 20) {
      this.errorMessage = 'Sobrenome deve conter entre 3 e 20 caracteres';
      return false;
    }
    if (this.userInputDto.email === null || this.userInputDto.email === '') {
      this.errorMessage = 'E-mail não pode ser vazio';
      return false;
    }
    if (this.userInputDto.email.length < 3 || this.userInputDto.email.length > 50) {
      this.errorMessage = 'E-mail deve conter entre 3 e 50 caracteres';
      return false;
    }
    if (this.userInputDto.role === null) {
      this.errorMessage = 'Informe o perfíl de acesso do usuário';
      return false;
    }
    if (this.isEditing === undefined) {
      if (this.password !== this.confirmPassword) {
        this.errorMessage = 'As senhas não são iguais';
        return false;
      }
      if (this.password.length < 6 || this.password.length > 14) {
        this.errorMessage = 'A senha deve conter entre 6 e 14 caracteres ';
        return false;
      }
    } else if (this.isEditing && this.password !== undefined && this.password !== '') {
      if (this.password !== this.confirmPassword) {
        this.errorMessage = 'As senhas não são iguais';
        return false;
      }
      if (this.password.length < 6 || this.password.length > 14) {
        this.errorMessage = 'A senha deve conter entre 6 e 14 caracteres ';
        return false;
      }
    }

    this.userInputDto.password = this.password;

    return true;
  }


  cancel() {
    this.router.navigateByUrl('/user');
  }

}
