export class Subject {
  id: number;
  abbreviation: string;
  fullName: string;


  static clone(subject: Subject): Subject {
    let cloned: Subject = new Subject();
    cloned.id = subject.id;
    cloned.abbreviation = subject.abbreviation;
    cloned.fullName = subject.fullName;
    return cloned;
  }

}
