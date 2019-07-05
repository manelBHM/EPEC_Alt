import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditerAvionComponent } from './editer-avion.component';

describe('EditerAvionComponent', () => {
  let component: EditerAvionComponent;
  let fixture: ComponentFixture<EditerAvionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditerAvionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditerAvionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
