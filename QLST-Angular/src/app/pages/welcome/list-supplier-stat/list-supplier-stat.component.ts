import { Component, OnInit } from '@angular/core';
import { SupplierStat } from 'src/app/models/SupplierStat';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-list-supplier-stat',
  templateUrl: './list-supplier-stat.component.html',
  styleUrls: ['./list-supplier-stat.component.less'],
})
export class ListSupplierStatComponent implements OnInit {
  listSupplierStat!: SupplierStat[];
  from = '';
  to = '';
  total = 0;
  constructor(private storageService: StorageService) {}

  ngOnInit(): void {
    this.listSupplierStat = JSON.parse(
      this.storageService.getListSupplierStat()
    );
    this.from = this.storageService.getFrom();
    this.to = this.storageService.getTo();
    console.log('--abc--');
    console.log(this.listSupplierStat);
    console.log(this.from);
    console.log(this.to);
    for (var i = 0; i < this.listSupplierStat.length; i++) {
      this.total += this.listSupplierStat[i].importAmount;
    }
    console.log('toal: ' + this.total);
  }
}
