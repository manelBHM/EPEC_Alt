import { TestBed } from '@angular/core/testing';

import { OrderzService } from './orderz.service';

describe('OrderzService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrderzService = TestBed.get(OrderzService);
    expect(service).toBeTruthy();
  });
});
