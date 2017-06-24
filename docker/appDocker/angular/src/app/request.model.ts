import {Product} from "./product.model";

export interface Request{
    id?: number;
    namePerson: string;
    surnames: string;
    address: string;
    phonePerson: string;
    phoneRestaurant?: string;
    postal: string;
    price: number;
    idRestaurant: number;
    delivered?: boolean;
    products: Array<Product>;
}