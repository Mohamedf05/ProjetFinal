import { TestBed } from '@angular/core/testing';

import { GuardAthleteService } from './guard-athlete.service';

describe('GuardAthleteService', () => {
  let service: GuardAthleteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardAthleteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
