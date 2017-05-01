import {Product} from "./product.model";
import {Request} from "./request.model";
import { SafeHtml } from '@angular/platform-browser';

export interface Restaurant {
    id?: number;
    name: string;
    password?: string;
    email: string;
    address: string;
    phone: string;
    postalCode?: string;
    image?: string;
    products?: Array<Product>;
    requests?: Array<Request>;
    imageSafe?: SafeHtml;
}