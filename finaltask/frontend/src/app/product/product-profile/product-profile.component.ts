import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../entitys/product';
import { ProductService } from '../../services/product.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-product-profile',
  templateUrl: './product-profile.component.html',
  styleUrls: ['./product-profile.component.css'],
})

export class ProductProfileComponent implements OnInit {
  public product: Product;
  public isProductUpdate: boolean;

  constructor(private route: ActivatedRoute,
              private productService: ProductService) {
    this.isProductUpdate = false;
  }

  public ngOnInit() {
    this.route.params.subscribe(
      (params) => {
        this.productService.getProductWithCharacteristics(+params.id).subscribe((response) => {
          this.product = response.data;
        });
      },
    );
  }

  productCreate(product: Product) {
    this.isProductUpdate = false;
    this.product = product;
  }

  updateProduct() {
    this.isProductUpdate = true;
  }
}
