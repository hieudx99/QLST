import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { getISOWeek } from 'date-fns';
import { SupplierStat } from 'src/app/models/SupplierStat';
import { ServiceService } from 'src/app/services/service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-supplier-stat-view',
  templateUrl: './supplier-stat-view.component.html',
  styleUrls: ['./supplier-stat-view.component.less'],
})
export class SupplierStatViewComponent implements OnInit {
  supplierStat!: SupplierStat;
  listSupplierStat!: SupplierStat[];
  form: any = {
    from: '',
    to: '',
  };
  constructor(
    private service: ServiceService,
    private storageService: StorageService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  btn_search_click() {
    this.form.from = (<HTMLInputElement>(
      document.getElementById('from-date')
    )).value;
    this.form.to = (<HTMLInputElement>document.getElementById('to-date')).value;
    this.service.getListSupplierStat(this.form).subscribe((data) => {
      this.listSupplierStat = data.body;
      console.log(data.body);
      console.log(this.listSupplierStat);
      this.storageService.saveListSupplierStat(this.listSupplierStat);
      this.storageService.saveFrom(this.form.from);
      this.storageService.saveTo(this.form.to);
      this.router.navigate(['/welcome/listsupplierstat']);
    });
  }
}
