import {Component, Injector, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProcessInputDto} from '../_model/process-input-dto';
import {ProcessService} from '../_service/process.service';

interface Users {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-process-new',
  templateUrl: './process-new.component.html',
  styleUrls: ['./process-new.component.css']
})
export class ProcessNewComponent implements OnInit {

  processInputDto: ProcessInputDto;

  protected router: Router;
  protected activatedRoute: ActivatedRoute;

  errorMessage: string;

  isEditing: number;

  users: Users[] = [];

  constructor(protected injector: Injector, private processService: ProcessService) {
    this.router = injector.get(Router);
    this.activatedRoute = injector.get(ActivatedRoute);
  }

  ngOnInit() {
    this.isEditing = this.activatedRoute.snapshot.params.id;
    this.processInputDto = new ProcessInputDto();

    this.getUsers();
    if (this.isEditing) {
      // this.getUser(this.isEditing);
    }
  }

  getUsers() {
    this.processService.getUser().subscribe((result => {
      result.forEach(value => {
        this.users.push({value: value.id, viewValue: (value.firstName + ' ' + value.lastName)});
      });
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
    this.processService.save(this.processInputDto).subscribe(() => {
      this.router.navigateByUrl('/process');
    }, error => {
      this.errorMessage = error.error.message;
    });
  }

  update(id: number) {
    this.errorMessage = null;
    this.processService.update(this.processInputDto, id).subscribe(() => {
      this.router.navigateByUrl('/process');
    }, error => {
      this.errorMessage = error.error.message;
    });
  }

  formValidate(): boolean {
    this.errorMessage = null;
    if (this.processInputDto.name === null || this.processInputDto.name === '') {
      this.errorMessage = 'Nome do processo não pode ser vazio';
      return false;
    }
    if (this.processInputDto.name.length < 3 || this.processInputDto.name.length > 50) {
      this.errorMessage = 'Nome do processo deve conter entre 3 e 50 caracteres';
      return false;
    }
    if (this.processInputDto.description === null || this.processInputDto.description === '') {
      this.errorMessage = 'Descrição do processo não pode ser vazio';
      return false;
    }
    if (this.processInputDto.description.length < 3 || this.processInputDto.description.length > 160) {
      this.errorMessage = 'Descrição do processo deve conter entre 3 e 160 caracteres';
      return false;
    }


    return true;
  }

  cancel() {
    this.router.navigateByUrl('/process');
  }

}
