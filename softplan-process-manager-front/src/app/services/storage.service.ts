import {Injectable} from '@angular/core';
import {LocalUser} from '../model/local_user';
import {STORAGE_KEYS} from '../config/storage_keys.config';
import * as jwt_decode from 'jwt-decode';

@Injectable()
export class StorageService {

  getLocalUser(): LocalUser {
    const usr = localStorage.getItem(STORAGE_KEYS.localUser);
    if (usr == null) {
      return null;
    } else {
      return JSON.parse(usr);
    }
  }

  getLocalUserJwtDecoder(): LocalUser {
    const usr = localStorage.getItem(STORAGE_KEYS.localUser);
    if (usr == null) {
      return null;
    } else {
      return jwt_decode(usr);
    }
  }


}
