export class Token {
  private _token : string;

  constructor() {

  }


  get token(): string {
    return this._token;
  }

  set token(value: string) {
    this._token = value;
  }
}
