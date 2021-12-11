import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from './models/Customer';
import { Staff } from './models/Staff';
import { StorageService } from './services/storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less'],
})
export class AppComponent implements OnInit {
  isLoggedIn = false;
  isManagerLoggedIn = false;
  isCollapsed = false;
  customer!: Customer;
  manager!: Staff;
  keyword = '';

  constructor(private storageService: StorageService, private router: Router) {}

  ngOnInit() {
    this.isLoggedIn = !!this.storageService.getCustomer();
    console.log(this.isLoggedIn);
    if (this.isLoggedIn) {
      this.customer = JSON.parse(this.storageService.getCustomer());
    }
    this.isManagerLoggedIn = !!this.storageService.getStaff();
    console.log(this.isManagerLoggedIn);
    if (this.isManagerLoggedIn) {
      this.manager = JSON.parse(this.storageService.getStaff());
    }
  }

  searchProduct(): void {
    console.log(this.keyword);
    this.storageService.saveKeyword(this.keyword);
    this.router
      .navigate(['/welcome/product'])
      .then(() => window.location.reload());
  }

  logout(): void {
    this.storageService.signOut();
    this.router.navigate(['/login']).then(() => {
      window.location.reload();
    });
  }
  reloadPage(): void {
    window.location.reload();
  }
}
