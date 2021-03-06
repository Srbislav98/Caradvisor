import { Boja } from "./boja";
import { Gorivo } from "./gorivo";
import { Karoserija } from "./karoserija";

export class Car{
    naziv:string;
    marka:string;
    karoserija:Karoserija;
    cena:number;
    godiste:number;
    gorivo:Gorivo;
    klima:boolean;
    kubikaza:number;
    boja:Boja;
    score:number;
    constructor(naziv:string,marka:string,karoserija:Karoserija,cena:number,godiste:number,gorivo:Gorivo,klima:boolean,kubikaza:number,boja:Boja,score:number){
        this.naziv=naziv;
        this.marka=marka;
        this.karoserija=karoserija;
        this.cena=cena;
        this.godiste=godiste;
        this.gorivo=gorivo;
        this.klima=klima;
        this.kubikaza=kubikaza;
        this.boja=boja;
        this.score=score;
    }
}