package lesson3task3;

public class Bucket {

    private int counter = 0;
    private int number = 5;
    private Flower bucket[];

    Bucket() {
        this.bucket = new Flower[number];
    }

    public void assemble(Flower flower) {
        this.bucket[this.counter] = flower;
        this.bucket[this.counter].setName(flower.getName());
        this.bucket[this.counter].setPrice(flower.getPrice());
        this.counter++;
    }

    public int getAmount() {

        int amount = 0;
        for (int i = 0; i < this.counter; i++) {
            amount = this.bucket[i].getPrice() + amount;
        }
        return amount;
    }

}
