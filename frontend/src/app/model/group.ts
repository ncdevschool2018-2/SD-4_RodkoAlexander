export class Group {
  number: string;
  course: number;
  description: string;

  constructor(){}


  static clone(group: Group): Group{
    let cloned: Group = new Group();
    cloned.number = group.number;
    cloned.course = group.course;
    cloned.description = group.description;
    return cloned;
  }

}
