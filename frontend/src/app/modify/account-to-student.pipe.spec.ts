import { AccountToStudentPipe } from './account-to-student.pipe';

describe('AccountToStudentPipe', () => {
  it('create an instance', () => {
    const pipe = new AccountToStudentPipe();
    expect(pipe).toBeTruthy();
  });
});
