import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {API_CONFIG} from '../../config/api.config';
import {ProcessInputDto} from '../_model/process-input-dto';
import {ProcessFeedbackInputDto} from '../_model/process-feedback-input-dto';

@Injectable({
  providedIn: 'root'
})
export class ProcessService {

  url = `${API_CONFIG.baseUrl}/process`;

  constructor(private http: HttpClient) {
  }

  listAll() {
    return this.http.get<Array<any>>(`${this.url}`);
  }

  getUser() {
    return this.http.get<Array<any>>(`${API_CONFIG.baseUrl}/user`);
  }

  getUsers(id: number) {
    return this.http.get<any>(`${this.url}/${id}`);
  }

  save(user: ProcessInputDto) {
    return this.http.post(`${this.url}`, user);
  }

  update(user: ProcessInputDto, id: number) {
    return this.http.put(`${this.url}/${id}`, user);
  }

  saveFeedback(feedback: ProcessFeedbackInputDto, id: number) {
    return this.http.post(`${this.url}/feedback/${id}`, feedback);
  }

  getDetail(id: number) {
    return this.http.get<any>(`${this.url}/detail/${id}`);
  }

}
