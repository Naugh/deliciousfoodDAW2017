import {Request} from "./request.model";

export interface Person {
    id?: number;
    name: string;
    surnames: string;
    password: string;
    email: string;
    address: string;
    phone: string;
    postalCode: string;
    requests?: Array<Request>;
}