import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PilotesComponent } from './pilotes.component';

describe('PilotesComponent', () => {
  let component: PilotesComponent;
  let fixture: ComponentFixture<PilotesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PilotesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PilotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
