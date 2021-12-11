import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/Product';
import { ServiceService } from 'src/app/services/service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-customer-home-view',
  templateUrl: './customer-home-view.component.html',
  styleUrls: ['./customer-home-view.component.less'],
})
export class CustomerHomeViewComponent implements OnInit {
  keyword!: string;
  listProduct!: Product[];
  selectedproduct!: Product;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private storageService: StorageService,
    private service: ServiceService
  ) {}

  ngOnInit(): void {
    this.keyword = this.storageService.getKeyword();
    if (this.keyword) {
      this.retrieveData();
    }
  }

  retrieveData() {
    this.service.getProductByName(this.keyword).subscribe(
      (data) => {
        this.listProduct = data;
        console.log(data);
        console.log(this.listProduct);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  setSelectedProduct(product: Product) {
    this.selectedproduct = product;
    this.storageService.saveProduct(this.selectedproduct);
    this.router.navigate(['/welcome/productdetail']);
  }
}
