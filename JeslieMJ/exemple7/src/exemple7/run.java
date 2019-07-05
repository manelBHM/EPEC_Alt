package exemple7;


public class run {    public static void main(String[] args) {
    // TODO Auto-generated method stub
    Ville v1 = new Ville("Lyon ",1500000);
    Ville v2 = new  Ville("Nice ");
    Capitale c1 = new Capitale ("Paris","France");
    Capitale c2 = new Capitale("Berlin","Allemagne");
    
        System.out.println(v1.presenteToi());
        System.out.println(v2.presenteToi());
        System.out.println(c1.presenteToi());
        System.out.println(c2.presenteToi());
        
}
}
