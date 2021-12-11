import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from '../services/storage.service';
import { ServiceService } from '../services/service.service';
import { Customer } from '../models/Customer';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less'],
})
export class LoginComponent implements OnInit {
  form: any = {
    username: '',
    password: '',
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  customer!: Customer;
  constructor(
    private service: ServiceService,
    private storageService: StorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (this.storageService.getCustomer()) {
      this.isLoggedIn = true;
      this.customer = JSON.parse(this.storageService.getCustomer());
      this.router.navigate(['/welcome']);
    }
  }

  onSubmit(): void {
    console.log(this.form.username);
    this.service.checkLogin(this.form).subscribe(
      (data) => {
        console.log(data.body);
        this.customer = data.body;
        this.storageService.saveCustomer(data.body);
        console.log(this.storageService.getCustomer());
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.router.navigate(['/welcome']).then(() => window.location.reload());
      },
      (err) => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }
}
