import { Characteristic } from './characteristic';
export class ProductCharacteristic {

  public amount: number;
  public characteristic: Characteristic;
  
  constructor(characteric: Characteristic, amount: number) {
      this.amount = amount;
      this.characteristic = characteric;
    }
}
