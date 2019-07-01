import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListVolComponent } from './list-vol.component';

describe('ListVolComponent', () => {
  let component: ListVolComponent;
  let fixture: ComponentFixture<ListVolComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListVolComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListVolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
