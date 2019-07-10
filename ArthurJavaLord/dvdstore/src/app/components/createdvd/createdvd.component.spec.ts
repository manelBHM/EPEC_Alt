import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatedvdComponent } from './createdvd.component';

describe('CreatedvdComponent', () => {
  let component: CreatedvdComponent;
  let fixture: ComponentFixture<CreatedvdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatedvdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatedvdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
