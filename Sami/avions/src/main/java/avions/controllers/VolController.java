package avions.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import avions.exceptions.Exceptions;
import avions.model.Admin;
import avions.model.Avion;
import avions.model.Pilote;
import avions.model.Vol;
import avions.repository.AdminRepository;
import avions.repository.AvionRepository;
import avions.repository.PiloteRepository;
import avions.repository.VolRepository;

@Controller

public class VolController {

	@Autowired
	PiloteRepository piloteRepository;
	@Autowired
	VolRepository volRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	AvionRepository avionRepository;

	
//Afficher la liste selon pilote ou admin	
	@RequestMapping(value = "/liste")
	public String showPilotFlights(@RequestParam(name = "id") long id, Model model) throws Exceptions{
		
		//long longid = Long.valueOf(id);
		
        List<Pilote>pilots=piloteRepository.findAll();
		List<Admin> admins=adminRepository.findAll();
		List<Long>ids=new ArrayList<Long>();
		
		for(Pilote p:pilots) {
			ids.add(p.getId());
		}
		for(Admin a:admins) {
			ids.add(a.getId());
		}
		if(!ids.contains(id)) {
			return "index";
		}
	
		

		for (Admin admin : admins) {

			if (id == admin.getId()) {

				return "redirect:/AdminList";
			}
		}

		Set<Vol> pilotFlights = volRepository.findFlightsByPilot(id);
		
		Pilote p=piloteRepository.findPiloteById(id);

		model.addAttribute("volspilote", pilotFlights);
		model.addAttribute("id", id);
		model.addAttribute("pilote", p);

		return "PilotFlights";
		}
	
	

	@RequestMapping(value = "/AdminList")
	public String adminList(Model model) {

		List<Admin> admins = adminRepository.findAll();

				List<Vol> vols = volRepository.findAll();
				List<Pilote> pilotes = piloteRepository.findAll();
				List<Avion> avions = avionRepository.findAll();

				model.addAttribute("vols", vols);
				model.addAttribute("pilotes", pilotes);
				model.addAttribute("avions", avions);

				return "AdminPage";
			
		}

	
	
	

	// Modifier un vol
		
		@RequestMapping(value = "/editFlight")
		public String editFlight(String id, Model model) {

			Vol vol = volRepository.getOne(id);
	     	
			
			model.addAttribute("vol", vol);

			return "modifiervol";

		}

		@RequestMapping(value = "/updateFlight", method = RequestMethod.POST)
		public String updateFlight(@Valid Vol vol, BindingResult bindingresult) {
			if (bindingresult.hasErrors()) {
				return "editFlight";
			}
			
		volRepository.save(vol);
			
			return "redirect:/AdminList";

		}
		

		// Modifier un pilote
			
			@RequestMapping(value = "/editPilot")
			public String editPilot(long id, Model model) {

				Pilote pilote = piloteRepository.getOne(id);
		     	
				
				model.addAttribute("pilote", pilote);

				return "modifierpilote";

			}

			@RequestMapping(value = "/updatePilot", method = RequestMethod.POST)
			public String updatePilot(@Valid Pilote pilote, BindingResult bindingresult) {
				if (bindingresult.hasErrors()) {
					return "editFlight";
				}
				
			piloteRepository.save(pilote);
				
				return "redirect:/AdminList";

			}
			
		// Modifier un avion
			
			@RequestMapping(value = "/editPlane")
			public String editPlane(long id, Model model) {

				Avion avion= avionRepository.getOne(id);
		     	
				
				model.addAttribute("avion", avion);

				return "modifieravion";

			}

			@RequestMapping(value = "/updatePlane", method = RequestMethod.POST)
			public String updatePlane(@Valid Avion avion, BindingResult bindingresult) {
				if (bindingresult.hasErrors()) {
					return "editPlane";
				}
				
			avionRepository.save(avion);
				
				return "redirect:/AdminList";

			}
			

			// Ajouter un pilote
			
				@RequestMapping(value = "/ajouterPilote", method = RequestMethod.GET)
				public String ajoutPilote(Model model) {

					model.addAttribute("pilot", new Pilote());

					return "ajouterpilote";

				}
				
				@RequestMapping(value = "/savePilote", method = RequestMethod.POST)
				public String save(@Valid Pilote pilote, BindingResult bindingresult) {
					if (bindingresult.hasErrors()) {
						return "ajouterpilote";
					}

					piloteRepository.save(pilote);

					return "redirect:/AdminList";

				}

				// Ajouter un avion
				
					@RequestMapping(value = "/ajouterAvion", method = RequestMethod.GET)
					public String ajoutAvion(Model model) {

						model.addAttribute("avion", new Avion());

						return "ajouteravion";

					}
					
					@RequestMapping(value = "/saveAvion", method = RequestMethod.POST)
					public String save(@Valid Avion avion, BindingResult bindingresult) {
						if (bindingresult.hasErrors()) {
							return "ajouteravion";
						}

						avionRepository.save(avion);

						return "redirect:/AdminList";

					}
					

					// Ajouter un vol
					
						@RequestMapping(value = "/ajouterVol", method = RequestMethod.GET)
						public String ajoutVol(Model model) {

							model.addAttribute("vol", new Vol());

							return "ajoutervol";

						}
						
						@RequestMapping(value = "/saveVol", method = RequestMethod.POST)
						public String save(@Valid Vol vol, BindingResult bindingresult) {
							if (bindingresult.hasErrors()) {
								return "ajoutervol";
							}

							volRepository.save(vol);

							return "redirect:/AdminList";

						}
						

						// Supprimer un vol
							@RequestMapping(value = "/deleteFlight")
							public String deleteFlight(String id) {

								volRepository.deleteById(id);

								return "redirect:/AdminList";

							}
							
							// Supprimer un avion
							@RequestMapping(value = "/deletePlane")
							public String deletePlane(long id) {

								avionRepository.deleteById(id);

								return "redirect:/AdminList";

							}
							// Supprimer un pilote
							@RequestMapping(value = "/deletePilot")
							public String deletePilot(long id) {

								piloteRepository.deleteById(id);

								return "redirect:/AdminList";

							}







}
