import {User} from "./user";
import {Role} from "./role";

export class Account {

  id: number;
  email: string;
  password: string;
  role: Role;
  user: User;

  constructor() {
    this.user = new User();/*
    this.role = new Role();*/
  }


  static clone(account: Account): Account {
    let cloned: Account = new Account();
    cloned.id = account.id;
    cloned.email = account.email;
    cloned.password = account.password;
    cloned.role = account.role;
    cloned.user = account.user;
    return cloned;
  }

}
