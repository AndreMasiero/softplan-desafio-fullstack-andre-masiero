import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserOutputDto} from './_model/user-output-dto';
import {UserInputDto} from './_model/user-input-dto';
import {API_CONFIG} from '../config/api.config';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  listAll() {
    return this.http.get<Array<UserOutputDto>>(`${API_CONFIG.baseUrl}/user`);
  }

  getUser(id: number) {
    return this.http.get<any>(`${API_CONFIG.baseUrl}/user/${id}`);
  }

  save(user: UserInputDto) {
    return this.http.post(`${API_CONFIG.baseUrl}/user`, user);
  }

  update(user: UserInputDto, id: number) {
    return this.http.put(`${API_CONFIG.baseUrl}/user/${id}`, user);
  }

  delete(id: number) {
    return this.http.delete(`${API_CONFIG.baseUrl}/user/${id}`);
  }

}
