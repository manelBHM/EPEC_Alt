import { Role } from './role.model';

export class User {

    public  id:number;
    public  username: String;
	public  password:String;
	public  firstName:String;
    public  lastName:String;
	public  email:String;
    public  tel:String;
    public roles: Role[];

    constructor(
       id:number,
       username: String,
       password:String,
       firstName:String,
       lastName:String,
       email:String,
       tel:String
    ){}
}
