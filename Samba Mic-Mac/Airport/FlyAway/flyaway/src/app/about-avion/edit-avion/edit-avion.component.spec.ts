import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAvionComponent } from './edit-avion.component';

describe('EditAvionComponent', () => {
  let component: EditAvionComponent;
  let fixture: ComponentFixture<EditAvionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAvionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAvionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
