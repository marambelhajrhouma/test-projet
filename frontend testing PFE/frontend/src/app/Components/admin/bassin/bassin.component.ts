import { Router } from '@angular/router';
import { BassinService } from '../../../Services/bassin.service';
import { Bassin } from './../../../models/bassin.models';
import { Component } from '@angular/core';

@Component({
  selector: 'app-bassin',
  templateUrl: './bassin.component.html',
  styleUrl: './bassin.component.css'
})
export class BassinComponent {
  bassins: Bassin[] = [];

  apiurl:string='http://localhost:8089/aquatresor/api';

  constructor(private bassinService: BassinService, private router: Router) { // Removed extra parenthesis
    //this.evenements = evenementService.listeEvenement();
  }

  ngOnInit(): void {
    this.chargerBassin();
  }

  chargerBassin() {
    this.bassinService.listeBassin().subscribe(bs => {
      console.log(bs);
      this.bassins = bs;
      this.bassins.forEach((b) => {
        // Check if images array exists and has at least one element
       if (b.images && b.images.length > 0 && b.images[0]) {
          b.imageStr = 'data:' + b.images[0].type + ';base64,' + b.images[0].image;
        } else {
          // Set a default image or placeholder if no image is available
          b.imageStr = 'assets/default-image.png'; // or any default image path
          console.log(`No image found for bassin: ${b.nomBassin}`);
        }
      });
    });
  }
}
