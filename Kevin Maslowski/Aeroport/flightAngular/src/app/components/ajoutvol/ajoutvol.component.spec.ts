import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutvolComponent } from './ajoutvol.component';

describe('AjoutvolComponent', () => {
  let component: AjoutvolComponent;
  let fixture: ComponentFixture<AjoutvolComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjoutvolComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutvolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
