import {RoleType} from '../enum/RoleType';

export class UserInputDto {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  role: RoleType;

  constructor() {
    this.firstName = null;
    this.lastName = null;
    this.email = null;
    this.password = null;
    this.role = null;
  }
}
