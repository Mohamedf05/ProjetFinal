import { TestBed } from '@angular/core/testing';

import { GuardSpectateurService } from './guard-spectateur.service';

describe('GuardSpectateurService', () => {
  let service: GuardSpectateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardSpectateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
