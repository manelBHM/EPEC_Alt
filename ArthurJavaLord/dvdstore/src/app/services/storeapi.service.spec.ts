import { TestBed } from '@angular/core/testing';

import { StoreapiService } from './storeapi.service';

describe('StoreapiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StoreapiService = TestBed.get(StoreapiService);
    expect(service).toBeTruthy();
  });
});
