import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ImportBill } from 'src/app/models/ImportBill';
import { ServiceService } from 'src/app/services/service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-import-history',
  templateUrl: './import-history.component.html',
  styleUrls: ['./import-history.component.less'],
})
export class ImportHistoryComponent implements OnInit {
  id!: number;
  listImportBill!: ImportBill[];
  from = '';
  to = '';
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private storageService: StorageService,
    private service: ServiceService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.from = this.storageService.getFrom();
    this.to = this.storageService.getTo();
    this.service
      .getImportHistory(this.from, this.to, this.id)
      .subscribe((data) => {
        this.listImportBill = data;
        console.log('adasdadadasdasdadadada');
        console.log(data);
        console.log(this.listImportBill);
      });
  }
}
