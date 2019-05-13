package lucky.airport.application.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lucky.airport.application.dao.*;
import lucky.airport.application.entity.*;

@Controller
@RequestMapping("lucky/airport/")
public class PiloteController {

	@Autowired
	protected PiloteDAO piloteDAO;

	@Autowired
	protected AvionDAO avionDAO;

	@Autowired
	private VolDAO volDAO;



	@GetMapping("/")
	public String index()
	{
		return "index";
	}



	@GetMapping("home")
	public String home(Model model)
	{
		model.addAttribute("pilote", piloteDAO.findAll());
		return "display";
	}




	////////////////////////////////////////////////ADMINISTRATOR /////////////////////////////////////////

	// Admin URL//

	@GetMapping("admin")
	public String admin(Model model)
	{
		model.addAttribute("pilote", piloteDAO.findAll());
		return "admin";
	}



	@RequestMapping("Admin")
	public String Admin(Model model, @RequestParam(name = "admin") String admin, @RequestParam(name = "pswd") String pswd)
	{

		if(admin.contains("admin") && pswd.contains("admin") || admin.contains("lucky") && pswd.contains("12345") )
		{
			model.addAttribute("pilote", piloteDAO.findAll());
			return "admin";
		}

		else {
			return "login";
		}

	}




	@GetMapping("adminpilote")
	public String adminPilote(Model model)
	{
		model.addAttribute("pilote", piloteDAO.findAll());
		return "adminPilote";
	}




	@GetMapping("adminavion")
	public String adminAvion(Model model)
	{
		model.addAttribute("avion", avionDAO.findAll());
		return "adminAvion";
	}




	@GetMapping("adminvol")
	public String adminVol(Model model)
	{
		model.addAttribute("vol", volDAO.findAll());
		return "adminVol";
	}


	@RequestMapping("adminlogin")
	public String adminLogin()
	{
		return "login";
	}


	@RequestMapping("pilotelogin")
	public String PilotLogin()
	{
		return "authenPilote";
	}


	////////////////////////////////////////////////  END ADMIN /////////////////////////////////////

	@ResponseBody
	@GetMapping(value = "pilote")
	public List<Pilote> getPilote()
	{
		Iterable<Pilote> pilote = piloteDAO.findAll();
		return (List<Pilote>) pilote;
	}


	@ResponseBody
	@GetMapping(value = "pilote/{id}")
	public Pilote getPiloteById(@PathVariable("id") Integer id)
	{				
		return piloteDAO.findPiloteById(id);
	}


	@PostMapping(value = "savepilote")
	public String savePilote(Model model, Pilote pilote, @RequestParam(name = "nom")String nom, @RequestParam(name = "site")String site, @RequestParam(name = "matricule")String matricule)
	{
		piloteDAO.save(pilote);

		return adminPilote(model);
	}



	@GetMapping("delete/pilote/")
	public String deletePilote(long id, Model model)
	{
		piloteDAO.deleteById(id);

		return adminPilote(model);
	}


	@RequestMapping(value = "edit/pilote/", method = {RequestMethod.GET, RequestMethod.POST})
	public String editPilote(Model model,  long id)
	{
		Pilote pilote = piloteDAO.findPiloteById(id);

		model.addAttribute("pilote", pilote);

		return "updatePilote";
	}



	@RequestMapping(value = "details/pilote", method = {RequestMethod.POST})
	public String piloteDetails(Model model,  String matricule)
	{
		Pilote pilote = piloteDAO.findPiloteByMatricule(matricule);

		model.addAttribute("pilote", pilote);


		return "display";
	}

	////////////////////////////////////////////////END PILOTE CONTROLER/////////////////////////////////////
	////////////////////////////////////////////////END PILOTE CONTROLER/////////////////////////////////////







	////////////////////////////////////////////////  AVION CONTROLLER /////////////////////////////////////


	@ResponseBody
	@GetMapping(value = "avion")
	public List<Avion> getAllAvion()
	{
		Iterable<Avion> avion = avionDAO.findAll();
		return (List<Avion>) avion;
	}




	@ResponseBody
	@GetMapping(value = "avion/{id}")
	public Avion getAvionById(@PathVariable("id") Integer id)
	{				
		return avionDAO.findAvionById(id);
	}




	@PostMapping(value = "saveavion")
	public String saveAvion(Model model, Avion avion, @RequestParam(name = "constructeur")String constructeur, @RequestParam(name = "modele")String modele, @RequestParam(name = "capacite")String capacite, @RequestParam(name = "site")String site)
	{
		avionDAO.save(avion);

		return adminAvion(model);
	}




	@GetMapping("delete/avion/")
	public String deleteAvion(long id, Model model)
	{
		avionDAO.deleteById(id);

		return adminAvion(model);
	}







	@RequestMapping(value = "edit/avion/", method = {RequestMethod.GET, RequestMethod.POST})
	public String editAvion(Model model,  long id)
	{
		Avion avion = avionDAO.findAvionById(id);

		model.addAttribute("avion", avion);

		return "updateAvion";
	}





	////////////////////////////////////////////////VOL CONTROLLER /////////////////////////////////////


	@ResponseBody
	@GetMapping(value = "vol")
	public List<Vol> getAllVol()
	{
		Iterable<Vol> vol = volDAO.findAll();
		return (List<Vol>) vol;
	}




	@ResponseBody
	@GetMapping(value = "vol/{id}")
	public Vol getvolById(@PathVariable("id") long id)
	{				
		return volDAO.findAvionById(id);
	}




	@PostMapping(value = "savevol")
	public String saveVol(Model model, Vol vol, @RequestParam(name = "site_depart")String site_depart, @RequestParam(name = "site_arrive")String site_arrive, @RequestParam(name = "heure_depart")String heure_depart, @RequestParam(name = "heure_arrivee")String heure_arrivee, @RequestParam(name = "avion_id")long avion_id, @RequestParam(name = "pilote_id")long pilote_id)                                       
	{
		volDAO.save(vol);

		return adminVol(model);
	}




	@GetMapping("delete/vol/")
	public String deleteVol(long id, Model model)
	{
		volDAO.deleteById(id);

		return adminVol(model);
	}



	@RequestMapping(value = "edit/vol/", method = {RequestMethod.GET, RequestMethod.POST})
	public String editVol(Model model,  long id)
	{
		Vol vol = volDAO.findVolById(id);

		model.addAttribute("vol", vol);

		return "updateVol";
	}



}
