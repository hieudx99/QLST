import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-stat-home-view',
  templateUrl: './view-stat-home-view.component.html',
  styleUrls: ['./view-stat-home-view.component.less'],
})
export class ViewStatHomeViewComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  onClick() {
    this.router.navigate(['/welcome/supplierstat']);
  }
}
