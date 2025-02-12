import { Injectable } from '@angular/core';
import { Bassin } from '../models/bassin.models';
import { Image } from '../models/image.models';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BassinService {
  
  /** Les variables **/
  bassins: Bassin[]=[];
  
  apiURL: string ='http://localhost:8089/aquatresor/api';
  //URL de spring Data REST
  apiURLTheme: string='http://localhost:8089/aquatresor/api/categories'; 

  /** Constructor **/
  constructor(private http: HttpClient) { }

  /** les fonctions **/

    //la liste des bassins
  listeBassin(): Observable<Bassin[]>{ 
    return this.http.get<Bassin[]>(this.apiURL + "/all"); 
  }



  uploadImage(file: File, filename: string): Observable<Image> {
    const imageFormData = new FormData();
    imageFormData.append('image', file, filename);
    const url = `${this.apiURL + '/image/upload'}`;
    return this.http.post<Image>(url, imageFormData);
  }

  loadImage(id: number): Observable<Image> {
    const url = `${this.apiURL + '/image/get/info'}/${id}`;
    return this.http.get<Image>(url);
  }

  uploadImageBassin(file: File, filename: string, idBassin: number): Observable<any> { 
    const imageFormData = new FormData(); 
    imageFormData.append('image', file, filename); 
    const url = `${this.apiURL + '/image/uploadImageB'}/${idBassin}`; 
    
    return this.http.post(url, imageFormData); 
  }
 

}
