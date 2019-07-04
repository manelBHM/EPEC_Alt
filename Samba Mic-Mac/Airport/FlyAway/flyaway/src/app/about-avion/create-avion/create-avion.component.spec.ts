import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAvionComponent } from './create-avion.component';

describe('CreateAvionComponent', () => {
  let component: CreateAvionComponent;
  let fixture: ComponentFixture<CreateAvionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAvionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAvionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
