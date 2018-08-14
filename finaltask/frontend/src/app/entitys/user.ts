import { Person } from './person';
import { Role } from './role';

export class User {

  public login: string;
  public password: string;
  public nickname: string;
  public id: LongRange;
  public role: Role;
  public person: Person;

  constructor() {
    this.person = new Person();
  }

  public clone(user: User) {
    this.password = user.password;
    this.nickname = user.nickname;
    this.id = user.id;
    this.role = user.role;
    this.person.firstName = user.person.firstName;
    this.person.email = user.person.email;
    this.person.id = user.person.id;
    this.person.phoneNumber = user.person.phoneNumber;
    this.person.secondName = user.person.secondName;
  }
}
