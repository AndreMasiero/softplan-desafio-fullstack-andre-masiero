import {Component, Injector, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ProcessService} from '../_service/process.service';
import {ProcessOutputDto} from '../_model/process-output-dto';
import {UserAuthorizationService} from '../../services/UserAuthorizationService';

@Component({
  selector: 'app-process-list',
  templateUrl: './process-list.component.html',
  styleUrls: ['./process-list.component.css']
})
export class ProcessListComponent implements OnInit {

  userAuthorization: UserAuthorizationService;

  protected router: Router;

  pending: Array<ProcessOutputDto>;
  inProgress: Array<ProcessOutputDto>;
  finished: Array<ProcessOutputDto>;

  constructor(protected injector: Injector,
              private processService: ProcessService) {
    this.router = injector.get(Router);
  }

  ngOnInit(): void {
    this.pending = new Array<ProcessOutputDto>();
    this.inProgress = new Array<ProcessOutputDto>();
    this.finished = new Array<ProcessOutputDto>();

    this.userAuthorization = new UserAuthorizationService();

    this.getListProcess();
  }

  create() {
    this.router.navigateByUrl('process/new');
  }

  getListProcess() {
    this.processService.listAll().subscribe((result) => {
      result.forEach(value => {
        if (value.processStatus === 'PENDING') {
          this.pending.push(value);
        } else if (value.processStatus === 'IN_PROGRESS') {
          this.inProgress.push(value);
        } else if (value.processStatus === 'FINISHED') {
          this.finished.push(value);
        }
      });

    });
  }

  detail(id: number) {
    console.log('jkdsjkhsdfjhkfds');
    this.router.navigateByUrl(`process/detail/${id}`);
  }

}
