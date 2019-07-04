import { TestBed } from '@angular/core/testing';

import { EcommercesService } from './ecommerces.service';

describe('EcommercesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EcommercesService = TestBed.get(EcommercesService);
    expect(service).toBeTruthy();
  });
});
