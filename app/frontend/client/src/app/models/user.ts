export class User{
    id:number;
    username:string;
    password:string;
    firstname:string;
    lastname:string;
    constructor(id:number,username:string,pass:string,fn:string,ln:string){
        this.id=id;
        this.username=username;
        this.password=pass;
        this.firstname=fn;
        this.lastname=ln;
    }
}