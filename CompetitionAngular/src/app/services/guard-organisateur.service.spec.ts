import { TestBed } from '@angular/core/testing';

import { GuardOrganisateurService } from './guard-organisateur.service';

describe('GuardOrganisateurService', () => {
  let service: GuardOrganisateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardOrganisateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
