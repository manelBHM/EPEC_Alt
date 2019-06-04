package exex;
import java.util.Comparator;

import com.profil.inter;
public class Stagiaire {

	int id;
	String nom;
	int age;


public Stagiaire(int id, String nom, Integer age) {
		// TODO Auto-generated constructor stub
	
	this.id = id;
	this.nom=nom;
	this.age=age;
	}


 





public int getId() {
	return id;
}








public String getNom() {
	return nom;
}




public int getAge() {
	return age;
}




public String toString () {
	String message="";
	
	return message = "\n id = "+this.getId() +" , name = "+this.getNom()+", age = "+this.getAge();

}
public static Comparator<Stagiaire>idComp= new Comparator <Stagiaire>() {

@Override
public int compare(Stagiaire o1, Stagiaire o2) {
	int id1 = o1.getId();
	int id2 = o2.getId();
	return id1 - id2 ;
	
	

}

};

public static Comparator<Stagiaire>idCompAge= new Comparator <Stagiaire>() {

  	public int compare(Stagiaire o1, Stagiaire o2) {
		int age1 = o1.getAge();
		int age2 = o2.getAge();
		return age1-age2 ;}
  	
};



	




}



