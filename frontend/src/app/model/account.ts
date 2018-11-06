export class Account {

  id: number;
  email: string;
  password: string;
  role: string;

  constructor(){}


  static clone(account: Account): Account{
    let cloned: Account = new Account();
    cloned.id = account.id;
    cloned.email = account.email;
    cloned.password = account.password;
    cloned.role = account.role;
    return cloned;
  }

}
