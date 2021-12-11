import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSupplierStatComponent } from './list-supplier-stat.component';

describe('ListSupplierStatComponent', () => {
  let component: ListSupplierStatComponent;
  let fixture: ComponentFixture<ListSupplierStatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSupplierStatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSupplierStatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
