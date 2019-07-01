import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPiloteComponent } from './list-pilote.component';

describe('ListPiloteComponent', () => {
  let component: ListPiloteComponent;
  let fixture: ComponentFixture<ListPiloteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListPiloteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPiloteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
