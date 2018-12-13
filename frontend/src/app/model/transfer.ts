export class Transfer {
  get student(): number {
    return this._student;
  }

  set student(value: number) {
    this._student = value;
  }

  get group(): number {
    return this._group;
  }

  set group(value: number) {
    this._group = value;
  }
  private _student: number;
  private _group: number;

  constructor() {

  }
}
