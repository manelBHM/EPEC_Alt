import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DvdspecComponent } from './dvdspec.component';

describe('DvdspecComponent', () => {
  let component: DvdspecComponent;
  let fixture: ComponentFixture<DvdspecComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DvdspecComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DvdspecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
