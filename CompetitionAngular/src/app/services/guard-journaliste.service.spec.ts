import { TestBed } from '@angular/core/testing';

import { GuardJournalisteService } from './guard-journaliste.service';

describe('GuardJournalisteService', () => {
  let service: GuardJournalisteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardJournalisteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
