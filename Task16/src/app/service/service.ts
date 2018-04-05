export class Service {
    id: number;
    category: String;
    price: number;


    constructor(price: number, category: String) {
        this.id = null;
        this.category = category;
        this.price = price;
    }
}