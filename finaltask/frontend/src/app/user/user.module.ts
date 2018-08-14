import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {DropdownModule} from 'primeng/dropdown';
import { PasswordModule } from 'primeng/password';
import { AppRoutingModule } from '../app-routing-module';
import { AuthorizationModule } from '../authorization/authorization.module';
import { LayoutModule } from '../layout/layout.module';
import { NameSplitterPipe } from '../pipes/customPipe';
import { UserService } from '../services/user.service';
import { UserListComponent } from './user-list/user-list.component';
import { UserPreviewComponent } from './user-preview/user-preview.component';
import { UserProfileMetaComponent } from './user-profile-meta/user-profile-meta.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  imports: [
      AppRoutingModule,
      DropdownModule,
      LayoutModule,
      FormsModule,
      CommonModule,
      PasswordModule,
      AuthorizationModule,
    ],
  declarations: [
      UserProfileComponent,
      UserListComponent,
      UserPreviewComponent,
      UserProfileMetaComponent,
      NameSplitterPipe,
    ],
  providers: [
      UserService,
    ],
  exports: [
      UserPreviewComponent,
      UserListComponent,
      UserProfileMetaComponent,
    ],
})
export class UserModule { }
