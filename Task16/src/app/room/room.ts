export class Room {
    id: number;
    number: number;
    price: number;
    capacity: number;
    numberOfStars: number;
    busy: boolean;
    status: String;

    constructor(number: number, price: number, capacity: number, numberOfStars: number, status: String, busy: boolean) {
        this.id = null;
        this.busy = busy;
        this.status = status;
        this.numberOfStars = numberOfStars;
        this.number = number;
        this.price = price;
        this.capacity = capacity;
    }
 
}