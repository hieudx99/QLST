import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplierStatViewComponent } from './supplier-stat-view.component';

describe('SupplierStatViewComponent', () => {
  let component: SupplierStatViewComponent;
  let fixture: ComponentFixture<SupplierStatViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupplierStatViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplierStatViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
