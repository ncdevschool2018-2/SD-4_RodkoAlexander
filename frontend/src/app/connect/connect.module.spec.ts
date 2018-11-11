import { ConnectModule } from './connect.module';

describe('ConnectModule', () => {
  let connectModule: ConnectModule;

  beforeEach(() => {
    connectModule = new ConnectModule();
  });

  it('should create an instance', () => {
    expect(connectModule).toBeTruthy();
  });
});
