export class Fotografija{
    id:number;
    carNaziv:string;
    foto:File;  
    lokacijaFajl:string;
    constructor( id:number,  carNaziv:string, foto:File,lokacijaFajl:string){
        this.id=id;
        this.carNaziv=carNaziv;
        this.foto=foto;
        this.lokacijaFajl=lokacijaFajl;
    }
}