import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteCarFormComponent } from './delete-car-form.component';

describe('DeleteCarFormComponent', () => {
  let component: DeleteCarFormComponent;
  let fixture: ComponentFixture<DeleteCarFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteCarFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteCarFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
