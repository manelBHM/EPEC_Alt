import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PiloteRegComponent } from './pilote-reg.component';

describe('PiloteRegComponent', () => {
  let component: PiloteRegComponent;
  let fixture: ComponentFixture<PiloteRegComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PiloteRegComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PiloteRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
