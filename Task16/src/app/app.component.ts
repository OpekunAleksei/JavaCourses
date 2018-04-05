import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams ,HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'


})
export class AppComponent implements OnInit{

   constructor(private httpClient: HttpClient){

   }
ngOnInit(){
  
}

}
  
  

  
  