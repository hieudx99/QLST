import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerHomeViewComponent } from './customer-home-view.component';

describe('CustomerHomeViewComponent', () => {
  let component: CustomerHomeViewComponent;
  let fixture: ComponentFixture<CustomerHomeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerHomeViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerHomeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
