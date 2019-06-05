import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAvionComponent } from './view-avion.component';

describe('ViewAvionComponent', () => {
  let component: ViewAvionComponent;
  let fixture: ComponentFixture<ViewAvionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAvionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAvionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
