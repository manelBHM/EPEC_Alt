import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PilotePageComponent } from './pilote-page.component';

describe('PilotePageComponent', () => {
  let component: PilotePageComponent;
  let fixture: ComponentFixture<PilotePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PilotePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PilotePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
