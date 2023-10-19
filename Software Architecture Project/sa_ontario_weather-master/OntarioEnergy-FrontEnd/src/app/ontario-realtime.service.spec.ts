import { TestBed } from '@angular/core/testing';

import { OntarioRealtimeService } from './ontario-realtime.service';

describe('OntarioRealtimeService', () => {
  let service: OntarioRealtimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OntarioRealtimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
