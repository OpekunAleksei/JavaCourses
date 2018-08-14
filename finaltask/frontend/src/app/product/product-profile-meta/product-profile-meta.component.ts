import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../entitys/product';
import { ProductService } from '../../services/product.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-product-profile-meta',
  templateUrl: './product-profile-meta.component.html',
  styleUrls: ['./product-profile-meta.component.css'],
})
export class ProductProfileMetaComponent implements OnInit {

  @Input() public product: Product;

  constructor(private userService: UserService) { }

  public ngOnInit() {
  }
}
