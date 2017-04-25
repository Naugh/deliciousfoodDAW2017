import {Product} from "./product.model";
import {Request} from "./request.model";

export interface Restaurant {
    id?: number;
    password: string;
    email: string;
    address: string;
    phone: string;
    postalCode: string;
    image: string;
    products: Array<Product>;
    requests: Array<Request>;
}