import { ModifyModule } from './modify.module';

describe('ModifyModule', () => {
  let modifyModule: ModifyModule;

  beforeEach(() => {
    modifyModule = new ModifyModule();
  });

  it('should create an instance', () => {
    expect(modifyModule).toBeTruthy();
  });
});
