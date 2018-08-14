import { Component, EventEmitter, Input, Output } from '@angular/core';
import { User } from '../../entitys/user';

@Component({
  selector: 'app-user-profile-meta',
  templateUrl: './user-profile-meta.component.html',
  styleUrls: ['./user-profile-meta.component.css'],
})

export class UserProfileMetaComponent {

  @Input() user: User;
  @Output() isUpdateStart = new EventEmitter();

  constructor() { }

  startUpdate() {
    this.isUpdateStart.emit(true);
  }
}
