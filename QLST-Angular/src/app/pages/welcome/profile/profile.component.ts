import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/Customer';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.less'],
})
export class ProfileComponent implements OnInit {
  customer!: Customer;

  constructor(private storageService: StorageService) {}

  ngOnInit(): void {
    this.customer = JSON.parse(this.storageService.getCustomer());
  }
}
