import { TestBed } from '@angular/core/testing';

import { AvionsService } from './avions.service';

describe('AvionsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AvionsService = TestBed.get(AvionsService);
    expect(service).toBeTruthy();
  });
});
