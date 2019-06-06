import { TestBed } from '@angular/core/testing';

import { PilotesService } from './pilotes.service';

describe('PilotesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PilotesService = TestBed.get(PilotesService);
    expect(service).toBeTruthy();
  });
});
