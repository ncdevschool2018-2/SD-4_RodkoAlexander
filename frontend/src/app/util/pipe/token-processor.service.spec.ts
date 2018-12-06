import { TestBed } from '@angular/core/testing';

import { TokenProcessorService } from './token-processor.service';

describe('TokenProcessorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TokenProcessorService = TestBed.get(TokenProcessorService);
    expect(service).toBeTruthy();
  });
});
