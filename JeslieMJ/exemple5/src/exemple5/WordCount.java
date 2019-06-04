package src.exemple5;
public class WordCount {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
String texte = "Trente rayons convergent au moyeu " +
        "mais c'est le vide médian " +
        "qui fait marcher le char." +"\n"+
        "On façonne l'argile pour en faire des vases,"+
        "mais c'est du vide interne que dépend leur usage."+"\n"+
        "Une maison est percée de porte et de fenêtres, "+
        "c'est encore du vide " +
        "qui permet l'habitat."+"\n"+
        "L'Etre donne des possibilités, c'est pas le non etre qu'on les utilise."+ "\n"+
        "The end \n";
/*System.out.println(texte + (texte.split(" |\n|.",-1).length - 1));*/

System.out.println(texte + "il y a : " + (texte.split(" ",-1).length - 1) + " mots");
System.out.println("ainsi que : " + (texte.split("\n",-1).length - 1) + " retours a la ligne");;
System.out.println("et enfin il y a : " + (texte.split(".",-1).length - 1)+ " caractères");;
    }

}