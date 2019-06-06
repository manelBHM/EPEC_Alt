package Aeroport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Aeoroport
 */
public class Aeoroport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ArrayList<Vol> liste = new ArrayList<Vol>();
	StringBuilder afficherListe;
	ListDAO produitdao = new ListDAO();
	StringBuilder str = new StringBuilder();
	
    public Aeoroport() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	Vol V1 = new Vol(200, 1, 100, "07:00:00", "09:00:00", "Nice", "Paris");
    	Vol V2 = new Vol(201, 2, 100, "11:00:00", "12:00:00", "Paris", "Toulouse");
    	Vol V3 = new Vol(202, 1, 101, "12:00:00", "14:00:00", "Paris", "Nice");
    	Vol V4 = new Vol(203, 3, 105, "09:00:00", "11:00:00", "Grenoble", "Toulouse");
    	Vol V5 = new Vol(204, 3, 105, "17:00:00", "19:00:00", "Toulouse", "Grenoble");
    	Vol V6 = new Vol(205, 7, 107, "06:00:00", "07:00:00", "Lyon", "Paris");
    	Vol V7 = new Vol(206, 8, 109, "10:00:00", "13:00:00", "Bastia", "Paris");
    	Vol V8 = new Vol(207, 9, 106, "07:00:00", "08:00:00", "Paris", "Brive");
    	Vol V9 = new Vol(208, 9, 106, "19:00:00", "20:00:00", "Brive", "Paris");
    	Vol V10 = new Vol(209, 7, 107, "18:00:00", "19:00:00", "Paris", "Lyon");
    	Vol V11 = new Vol(210, 2, 102, "15:00:00", "16:00:00", "Toulouse", "Paris");
    	Vol V12 = new Vol(211, 4, 101, "17:00:00", "19:00:00", "Nice", "Nantes");
    	
    	/*liste.add(V1);
    	liste.add(V2);
    	liste.add(V3);
    	liste.add(V4);
    	liste.add(V5);
    	liste.add(V6);
    	liste.add(V7);
    	liste.add(V8);
    	liste.add(V9);
    	liste.add(V10);
    	liste.add(V11);
    	liste.add(V12);*/
    	
    	liste = new ListDAO().getAll();
    }
    



public StringBuilder afficherListes(ArrayList<Vol> liste) {

	int id = 1;
	for (Vol element : this.liste) {

		str.append(id + "- " + " " + element.getVol());
		id++;
	}

	System.out.println("");
	return str;
}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*String info = request.getQueryString();
		String [] splitEsp = info.split("&");
		
		Map<String, String> valeur = new HashMap<String, String>();
		
		for (String element : splitEsp) {
			String [] splitEquals = element.split("=");
			
			if (splitEquals.length == 2) {
				valeur.put(splitEquals[0], splitEquals[1]);
			}
		}*/
		/*Vol vol = null;
		for (Vol element:listeVol) {
            vol.addVol(element, 1);
        }
				
		StringBuilder afficher = Pilote.afficherListe(listeVol);
		request.setAttribute("afficherListe", afficherListe);*/
		
		StringBuilder afficherProduit = afficherListes(liste);
		request.setAttribute("afficherProduit", afficherProduit);
		
        this.getServletContext().getRequestDispatcher("/siteVol.jsp").forward(request, response);
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
