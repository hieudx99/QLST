import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from '../services/storage.service';
import { ServiceService } from '../services/service.service';
import { Customer } from '../models/Customer';
import { Staff } from '../models/Staff';

@Component({
  selector: 'app-login-manager',
  templateUrl: './login-manager.component.html',
  styleUrls: ['./login-manager.component.less'],
})
export class LoginManagerComponent implements OnInit {
  form: any = {
    username: '',
    password: '',
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  staff!: Staff;
  constructor(
    private service: ServiceService,
    private storageService: StorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (this.storageService.getStaff()) {
      this.isLoggedIn = true;
      this.staff = JSON.parse(this.storageService.getStaff());
      this.router.navigate(['/welcome']);
    }
  }

  onSubmit(): void {
    console.log(this.form.username);
    this.service.checkLoginManager(this.form).subscribe(
      (data) => {
        console.log(data.body);
        this.staff = data.body;
        this.storageService.saveStaff(data.body);
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
