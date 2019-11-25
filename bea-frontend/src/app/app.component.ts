import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <h1>{{title}} <br> {{message}}</h1>
    <br>
    <h4>{{quote}}</h4>
   <h3></h3>
    
    
  
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BEA';
  message = ' Welcome to the beautiful academy!';
  quote = 'Beauty begins the moment you decide to be yourself. Coco Chanel';
}
