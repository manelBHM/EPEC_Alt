import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditVolComponent } from './edit-vol.component';

describe('EditVolComponent', () => {
  let component: EditVolComponent;
  let fixture: ComponentFixture<EditVolComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditVolComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditVolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
