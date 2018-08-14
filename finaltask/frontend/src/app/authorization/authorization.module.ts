import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InputMaskModule } from 'primeng/components/inputmask/inputmask';
import { KeyFilterModule } from 'primeng/keyfilter';
import {PanelModule} from 'primeng/panel';
import { PasswordModule } from 'primeng/password';
import { ButtonModule, InputTextModule } from 'primeng/primeng';
import { EqualValidator } from '../equalValidator';
import { RegistrationComponent } from './registration/registration.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ValidatorMessageComponent } from './validator-message.directive';

@NgModule({
  imports: [
    FormsModule,
    InputTextModule,
    KeyFilterModule,
    ReactiveFormsModule,
    PanelModule,
    ButtonModule,
    InputMaskModule,
    PasswordModule,
    BrowserAnimationsModule,
  ],
  declarations: [
    ValidatorMessageComponent,
    EqualValidator,
    RegistrationComponent,
    SignInComponent,
  ],
  exports: [
    SignInComponent,
    ValidatorMessageComponent,
    RegistrationComponent,
  ],
})

export class AuthorizationModule { }
