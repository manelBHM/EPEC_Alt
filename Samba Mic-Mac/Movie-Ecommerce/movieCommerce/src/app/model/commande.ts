import { Article } from './article';
import { Payement } from './payement';
import { User } from './user';
import { Livraison } from './livraison';

export class Commande {
    id : Number;
    customer :User;
    article : Article;
    dateCommande : Date;
    address : String;
    total : Number;
    dateLivraison : Date;
    payement : Payement;
    livraison : Livraison;
}
