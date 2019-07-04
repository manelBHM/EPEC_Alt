import { TestBed } from '@angular/core/testing';

import { PannierService } from './pannier.service';

describe('PannierService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PannierService = TestBed.get(PannierService);
    expect(service).toBeTruthy();
  });
});
