import { Categorie } from "./categorie.models";
import { Image } from "./image.models";

export class Bassin{
    idBassin!: number; 
    nomBassin!: string;
    description!: string;
    prix!: number;
   
    materiau!: string;
    couleur!: string;
    dimensions!: string;
    disponible!:boolean;
    stock!:number;

    categorie!: Categorie;

    image! : Image;
    imageStr!:string;

    images!: Image[];
}