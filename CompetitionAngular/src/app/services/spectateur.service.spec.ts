import { TestBed } from '@angular/core/testing';

import { SpectateurService } from './spectateur.service';

describe('SpectateurService', () => {
  let service: SpectateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpectateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
