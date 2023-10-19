import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OntarioRealtimeDataComponent } from './ontario-realtime-data.component';

describe('OntarioRealtimeDataComponent', () => {
  let component: OntarioRealtimeDataComponent;
  let fixture: ComponentFixture<OntarioRealtimeDataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OntarioRealtimeDataComponent]
    });
    fixture = TestBed.createComponent(OntarioRealtimeDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
