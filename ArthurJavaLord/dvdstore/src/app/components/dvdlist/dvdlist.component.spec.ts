import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DvdlistComponent } from './dvdlist.component';

describe('DvdlistComponent', () => {
  let component: DvdlistComponent;
  let fixture: ComponentFixture<DvdlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DvdlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DvdlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
