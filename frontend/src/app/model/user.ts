export class User {
  id: number;
  firstName: string;
  lastName: string;
  role: string;

  constructor(){}


  static clone(user: User): User{
    let cloned: User = new User();
    cloned.id = user.id;
    cloned.firstName = user.firstName;
    cloned.lastName = user.lastName;
    cloned.role = user.role;
    return cloned;
  }

}
