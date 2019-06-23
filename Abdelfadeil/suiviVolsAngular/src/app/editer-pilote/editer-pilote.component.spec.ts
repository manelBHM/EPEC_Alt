import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditerPiloteComponent } from './editer-pilote.component';

describe('EditerPiloteComponent', () => {
  let component: EditerPiloteComponent;
  let fixture: ComponentFixture<EditerPiloteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditerPiloteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditerPiloteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
