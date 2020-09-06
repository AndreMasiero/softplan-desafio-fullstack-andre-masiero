import {Component, Injector, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ProcessService} from '../_service/process.service';
import {ProcessOutputDto} from '../_model/process-output-dto';

@Component({
  selector: 'app-process-list',
  templateUrl: './process-list.component.html',
  styleUrls: ['./process-list.component.css']
})
export class ProcessListComponent implements OnInit {

  protected router: Router;

  pending: Array<ProcessOutputDto>;
  running: Array<ProcessOutputDto>;
  finished: Array<ProcessOutputDto>;

  constructor(protected injector: Injector,
              private processService: ProcessService) {
    this.router = injector.get(Router);
  }

  ngOnInit(): void {
    this.pending = new Array<ProcessOutputDto>();
    this.running = new Array<ProcessOutputDto>();
    this.finished = new Array<ProcessOutputDto>();

    this.getListProcess();
  }

  create() {
    this.router.navigateByUrl('process/new');
  }

  getListProcess() {
    this.processService.listAll().subscribe((result) => {
      this.pending = result;
      this.running = result;
      this.finished = result;
    });
  }


  update(id: number) {
    this.router.navigateByUrl(`process/new/${id}`);
  }

}
