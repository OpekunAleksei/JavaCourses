import { Component, Input } from '@angular/core';
import { User } from '../../entitys/user';

@Component({
  selector: 'app-user-preview',
  templateUrl: './user-preview.component.html',
  styleUrls: ['./user-preview.component.css'],
})

export class UserPreviewComponent {
  @Input() user: User;

  constructor() { }

}
