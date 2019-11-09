import { TestBed } from '@angular/core/testing';

import { ExpenseclaimService } from './expenseclaim.service';

describe('ExpenseclaimService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExpenseclaimService = TestBed.get(ExpenseclaimService);
    expect(service).toBeTruthy();
  });
});
