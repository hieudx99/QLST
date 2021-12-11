import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ImportBill } from 'src/app/models/ImportBill';
import { ServiceService } from 'src/app/services/service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-bill-detail',
  templateUrl: './bill-detail.component.html',
  styleUrls: ['./bill-detail.component.less'],
})
export class BillDetailComponent implements OnInit {
  id!: number;
  importBill!: ImportBill;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private storageService: StorageService,
    private service: ServiceService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.retrieveData();
  }
  retrieveData() {
    this.service.getBillDetail(this.id).subscribe((data) => {
      this.importBill = data;
      console.log('-----bill detail-----');
      console.log(data);
      console.log(this.importBill);
    });
  }
}
