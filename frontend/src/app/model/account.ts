import {User} from "./user";

export class Account {

  id: number;
  email: string;
  password: string;
  role: string;
  user: User;

  constructor() {
    this.user = new User();
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
