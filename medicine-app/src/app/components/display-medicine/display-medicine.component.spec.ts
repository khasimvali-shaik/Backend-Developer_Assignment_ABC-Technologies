import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayMedicineComponent } from './display-medicine.component';

describe('DisplayMedicineComponent', () => {
  let component: DisplayMedicineComponent;
  let fixture: ComponentFixture<DisplayMedicineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayMedicineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayMedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
