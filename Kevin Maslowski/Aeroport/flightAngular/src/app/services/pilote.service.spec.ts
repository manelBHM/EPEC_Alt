import { TestBed } from '@angular/core/testing';

import { PiloteService } from './pilote.service';

describe('PiloteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PiloteService = TestBed.get(PiloteService);
    expect(service).toBeTruthy();
  });
});
