import {Injectable} from '@angular/core';
import {StorageService} from './storage.service';

@Injectable()
export class UserAuthorizationService {
  public storageService: StorageService;

  public admin = new Array('ROLE_ADMIN');
  public triator = new Array('ROLE_TRIATOR');
  public finisher = new Array('ROLE_FINISHER');

  constructor() {
    this.storageService = new StorageService();
  }

  hasAuthorizationType = function(...role: any[]) {

    const rolesAuthoritiesKey = [];
    if (this.storageService.getLocalUserJwtDecoder() == null) {
      return false;
    }
    rolesAuthoritiesKey.push(this.storageService.getLocalUserJwtDecoder().AUTHORITIES_KEY);

    for (let i = 0; i < rolesAuthoritiesKey.length; i++) {
      for (let j = 0; j < role.length; j++) {
        if (rolesAuthoritiesKey[i] === role[j][0]) {
          return true;
        }
      }
    }
    return false;
  };

}
