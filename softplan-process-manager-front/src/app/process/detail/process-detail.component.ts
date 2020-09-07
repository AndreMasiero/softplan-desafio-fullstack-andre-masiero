import {Component, Injector, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProcessService} from '../_service/process.service';
import {ProcessFeedbackInputDto} from '../_model/process-feedback-input-dto';
import {ProcessDetailOutputDto} from '../_model/detail/process-detail-output-dto';
import {ProcessStatus} from '../enum/ProcessStatus';
import {UserAuthorizationService} from '../../services/UserAuthorizationService';

interface Users {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-process-detail',
  templateUrl: './process-detail.component.html',
  styleUrls: ['./process-detail.component.css']
})
export class ProcessDetailComponent implements OnInit {

  userAuthorization: UserAuthorizationService;

  processFeedbackInputDto: ProcessFeedbackInputDto;
  details: ProcessDetailOutputDto;
  blockInsertFeedbackButtom = false;

  protected router: Router;
  protected activatedRoute: ActivatedRoute;

  displayedColumns: string[] = ['user', 'feedback', 'insertDate'];
  dateFormat: string;

  errorMessage: string;

  isEditing: number;

  constructor(protected injector: Injector, private processService: ProcessService) {
    this.router = injector.get(Router);
    this.activatedRoute = injector.get(ActivatedRoute);
  }

  ngOnInit() {
    this.isEditing = this.activatedRoute.snapshot.params.id;
    this.processFeedbackInputDto = new ProcessFeedbackInputDto();
    this.details = new ProcessDetailOutputDto();

    this.userAuthorization = new UserAuthorizationService();
    this.profileValidate();

    this.dateFormat = 'dd/MM/yyyy HH:ss';

    this.getDetail();
  }

  getDetail() {
    this.processService.getDetail(this.isEditing).subscribe((result => {
      this.details = result;
      if (this.details.status === ProcessStatus.FINISHED) {
        this.blockInsertFeedbackButtom = true;
      }
    }), error => {
      this.errorMessage = 'Não foi possível recuperar os dados do processo.';
    });
  }

  saveFeedback() {
    if (this.formValidate() === false) {
      return;
    }

    this.processService.saveFeedback(this.processFeedbackInputDto, this.isEditing).subscribe(() => {
      this.getDetail();
    }, error => {
      this.errorMessage = error.error.message;
    });
  }


  formValidate(): boolean {
    this.errorMessage = null;
    if (this.processFeedbackInputDto.feedback === null || this.processFeedbackInputDto.feedback === '') {
      this.errorMessage = 'Parecer do processo não pode ser vazio';
      return false;
    }
    if (this.processFeedbackInputDto.feedback.length < 3 || this.processFeedbackInputDto.feedback.length > 100) {
      this.errorMessage = 'Parecer do processo deve conter entre 3 e 100 caracteres';
      return false;
    }

    return true;
  }

  back() {
    this.router.navigateByUrl('/process');
  }

  profileValidate() {
    if (this.userAuthorization.hasAuthorizationType(this.userAuthorization.admin)) {
      this.blockInsertFeedbackButtom = true;
    }
  }

}
