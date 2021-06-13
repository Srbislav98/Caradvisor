import { Boja } from "./boja";
import { Gorivo } from "./gorivo";
import { Karoserija } from "./karoserija";

export class AutomobilQuery{
    id:number;
    marka:string;
    karoserija:Karoserija;
    cena:number;
    godiste:number;
    gorivo:Gorivo;
    klima:boolean;
    kubikaza:number;
    boja:Boja;
    constructor(id:number,marka:string,karoserija:Karoserija,cena:number,godiste:number,gorivo:Gorivo,klima:boolean,kubikaza:number,boja:Boja){
        this.id=id;
        this.marka=marka;
        this.karoserija=karoserija;
        this.cena=cena;
        this.godiste=godiste;
        this.gorivo=gorivo;
        this.klima=klima;
        this.kubikaza=kubikaza;
        this.boja=boja;
    }
}