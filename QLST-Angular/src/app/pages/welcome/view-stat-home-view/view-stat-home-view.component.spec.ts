import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewStatHomeViewComponent } from './view-stat-home-view.component';

describe('ViewStatHomeViewComponent', () => {
  let component: ViewStatHomeViewComponent;
  let fixture: ComponentFixture<ViewStatHomeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewStatHomeViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewStatHomeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
