import { Boja } from "./boja";
import { Gorivo } from "./gorivo";
import { Karoserija } from "./karoserija";
import { MestoPrebivalista } from "./mestoPrebivalista";
import { Pol } from "./pol";

export class OsobaQuery{
    pol:Pol;
    godiste:number;
    zaposlenost:boolean;
    mestoPrebivalista:MestoPrebivalista;
    brojClanovaPorodice:number;
    constructor(pol:Pol,godiste:number,zaposlenost:boolean,mestoPrebivalista:MestoPrebivalista,brojClanovaPorodice:number){
        this.pol=pol;
        this.godiste=godiste;
        this.zaposlenost=zaposlenost;
        this.mestoPrebivalista=mestoPrebivalista;
        this.brojClanovaPorodice=brojClanovaPorodice;
    }
}