import {Component, Injector, OnInit} from '@angular/core';
import {UserService} from '../user.service';
import {UserOutputDto} from '../_model/user-output-dto';
import {Router} from '@angular/router';
import {UserAuthorizationService} from '../../services/UserAuthorizationService';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  protected router: Router;

  userAuthorization: UserAuthorizationService;

  displayedColumns: string[] = ['firstName', 'lastName', 'email', 'id'];
  dataSource: any[];

  outputDtos: Array<UserOutputDto>;

  errorToDelete: string;

  constructor(protected injector: Injector,
              private userService: UserService) {
    this.router = injector.get(Router);
    this.outputDtos = Array<UserOutputDto>();

    this.userAuthorization = new UserAuthorizationService();

    this.getListUser();
    this.validateAccessAuthorization();
  }

  ngOnInit() {
  }

  getListUser() {
    this.userService.listAll().subscribe((result) => {
      this.outputDtos = result;

      this.dataSource = [];
      this.outputDtos.forEach(dto => {
        this.dataSource.push({firstName: dto.firstName, lastName: dto.lastName, email: dto.email, id: dto.id});
      });

    });
  }

  create() {
    this.router.navigateByUrl('user/new');
  }

  update(id: number) {
    this.router.navigateByUrl(`user/new/${id}`);
  }

  delete(id: number) {
    this.userService.delete(id).subscribe((result => {
      this.getListUser();
    }), error => {
      this.errorToDelete = 'Erro ao deletar o registro';
    });
  }

  validateAccessAuthorization() {
    if (!this.userAuthorization.hasAuthorizationType(
      this.userAuthorization.admin,
      this.userAuthorization.triator)) {

      this.router.navigateByUrl('/');
    }
  }

}
