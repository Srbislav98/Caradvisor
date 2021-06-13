import { AutomobilQuery } from "./automobilQuery";
import { OsobaQuery } from "./osobaQuery";

export class Query{
    automobilQuery:AutomobilQuery;
    osobaQuery:OsobaQuery;
    constructor(automobilQuery:AutomobilQuery,osobaQuery:OsobaQuery){
        this.automobilQuery=automobilQuery;
        this.osobaQuery=osobaQuery;
    }
}