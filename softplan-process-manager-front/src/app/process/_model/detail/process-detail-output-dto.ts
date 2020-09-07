import {UserOutputDto} from '../../../user/_model/user-output-dto';
import {ProcessFeedbackOutputDto} from './process-feedback-output-dto';
import {ProcessStatus} from '../../enum/ProcessStatus';

export class ProcessDetailOutputDto {
  name: string;
  description: string;
  insertDate: any;
  status: ProcessStatus;
  collaborators: Array<UserOutputDto>;
  feedbacks: Array<ProcessFeedbackOutputDto>;

  constructor() {
    this.name = null;
    this.description = null;
    this.insertDate = null;
    this.collaborators = [];
    this.feedbacks = [];
  }
}
