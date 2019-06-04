package com.project.aeroport.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.aeroport.dao.AeroportRepository;
import com.project.aeroport.dao.AeroportRepositoryPilote;
import com.project.aeroport.dao.AeroportRepositoryVol;
import com.project.aeroport.entities.Avion;
import com.project.aeroport.entities.Pilote;
import com.project.aeroport.entities.Vol;
import com.project.aeroport.log.LoginForm;

@Controller
//@RequestMapping(value="/Aeroport")
public class AeroportController {
	
	@Autowired
	private AeroportRepository aeroportRepository;
	@Autowired
	private AeroportRepositoryPilote aeroportRepositoryP;
	@Autowired
	private AeroportRepositoryVol aeroportRepositoryV;

	@RequestMapping("/Aeroport")
	public String acceuil(Model model, @RequestParam(name="motCle", defaultValue="")String mc) {
		//List<Pilote> listPilote=aeroportRepositoryP.cherhcerPiloteI("%"+mc+"%");
		List<Vol> listVol=aeroportRepositoryV.searchVolbyPilote("%"+mc+"%");
		model.addAttribute("listVol", listVol);
		model.addAttribute("motCle", mc);
		return "aeroport";
	}
	
	//Pour avoir la page login
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public String getLoginForm() {
		return "loginAdmin";
	}
	//verification identifiants
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if("admin".equals(username) && "a".equals(password)) {
			return "redirect:Aeroport/List";
		}
		model.addAttribute("invalidCredentials", true);
		
		return "loginAdmin";
	}

	@RequestMapping(value="Aeroport/List")
	public String avionList(Model model,@RequestParam(name ="motCle",defaultValue="")String mc) {
		List<Avion> listAv = aeroportRepository.findAll();
		model.addAttribute("avions", listAv);

		List<Pilote>listPi = aeroportRepositoryP.findAll();
		model.addAttribute("pilots", listPi);

		List<Vol>listVol = aeroportRepositoryV.findAll();
		model.addAttribute("vols", listVol);

		return "list";
	}
	//-------------creation Pilote
	@RequestMapping(value="Aeroport/FormulairePilote", method=RequestMethod.GET)
	public String formPilote(Model model) {

		model.addAttribute("unPilote", new Pilote());

		return "formPilote";
	}
	@RequestMapping(value="Aeroport/SavePilote", method=RequestMethod.POST)
	public String savePilote(Pilote pl) {

		aeroportRepositoryP.save(pl);

		return "redirect:List"; 
	}

	//-----------------creation Avion

	@RequestMapping(value="Aeroport/FormulaireAvion", method=RequestMethod.GET)
	public String formAvion(Model model) {

		model.addAttribute("unAvion", new Avion());

		return "formAvion";
	}
	@RequestMapping(value="Aeroport/SaveAvion", method=RequestMethod.POST)
	public String saveAvion(Avion av) {

		aeroportRepository.save(av);

		return "redirect:Aeroport/List"; 
	}

	//-------------------creation Vol

	@RequestMapping(value="Aeroport/FormulaireVol", method=RequestMethod.GET)
	public String formVol(Model model) {

		model.addAttribute("unVol", new Vol());

		return "formVol";
	}
	@RequestMapping(value="Aeroport/SaveVol", method=RequestMethod.POST)
	public String saveVol(Vol vl) {

		aeroportRepositoryV.save(vl);

		return "redirect:List"; 
	}

	//--------Supprimer
	@RequestMapping(value="Aeroport/SupprimerAvion")
	public String supprimerAvion(Long id) {
		aeroportRepository.deleteById(id);
		return "redirect:List";
	}

	@RequestMapping(value="Aeroport/SupprimerPilote")
	public String supprimerPilote(Long id) {
		aeroportRepositoryP.deleteById(id);
		return "redirect:List";
	}

	@RequestMapping(value="Aeroport/SupprimerVol")
	public String supprimerVol(String id) {
		aeroportRepositoryV.deleteById(id);
		return "redirect:List";
	}


	//-------------Edit Avion

	@RequestMapping(value="Aeroport/EditAvion")
	public String editAvion(Long id,Model model) {

		Avion avion = aeroportRepository.getOne(id);

		model.addAttribute("unAvion", avion);

		return "editAvion";
	}
	@RequestMapping(value="Aeroport/UpdateAvion", method=RequestMethod.POST)
	public String saveEditAvion(Avion av) {

		aeroportRepository.save(av);

		return "redirect:List";
	}

	//-------------Edit Pilote


	@RequestMapping(value="Aeroport/EditPilote")
	public String editPilote(Long id,Model model) {

		Pilote pilote = aeroportRepositoryP.getOne(id);

		model.addAttribute("unPilote", pilote);

		return "editPilote";
	}
	@RequestMapping(value="Aeroport/UpdatePilote", method=RequestMethod.POST)
	public String saveEditPilote(Pilote pl) {

		aeroportRepositoryP.save(pl);

		return "redirect:List";
	}

	//-------------Edit Vol

	@RequestMapping(value="Aeroport/EditVol")
	public String editVol(String id,Model model) {

		Vol vol = aeroportRepositoryV.getOne(id);

		model.addAttribute("unVol", vol);

		return "editVol";
	}
	@RequestMapping(value="Aeroport/UpdateVol", method=RequestMethod.POST)
	public String saveEditVol(Vol vl) {

		aeroportRepositoryV.save(vl);

		return "redirect:List";
	}
}