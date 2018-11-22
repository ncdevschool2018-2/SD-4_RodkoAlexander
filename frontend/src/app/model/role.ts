export class Role {
  id: number;
  name: string;

  constructor() {

  }

  static clone(role: Role): Role {
    let cloned: Role = new Role();
    cloned.id = role.id;
    cloned.name = role.name;
    return cloned;
  }
}
