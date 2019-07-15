package com.dvdenligne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dvdenligne.entity.Catalogue;
import com.dvdenligne.entity.Client;
import com.dvdenligne.entity.Film;
import com.dvdenligne.entity.Langue;
import com.dvdenligne.repo.CatalogueRepo;
import com.dvdenligne.repo.ClientRepo;
import com.dvdenligne.repo.FilmRepo;
import com.dvdenligne.repo.LangueRepo;

@Controller
@RequestMapping("boutiquedvd/api")
public class EmployeController {

	@Autowired
	CatalogueRepo cataloguerepo;
	
	@Autowired
	FilmRepo filmrepo;
	
	@Autowired
	ClientRepo clientrepo;
	
	@Autowired
	LangueRepo languerepo;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	
	
	@GetMapping("/admin/login")
	public String adminLogin()
	{
		return "adminlogin";
	}
	
	
	@GetMapping("/admin/home")
	public String GetAdminPage()
	{
		return "admin";
	}
	
	
	
	@GetMapping("/employeAdminpage")
	public String adminPage(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password)
	{
		if(username.contains("lucky") && password.contains("12345")){return "admin";}
		else {return "adminlogin";}
		
	}
	
	@Configuration
	public class GlobalCorsConfiguration {

	    public GlobalCorsConfiguration() {
	        super();
	    }

	    /**
	     * Bean to define global CORS.
	     * 
	     * @return
	     */
	    @Bean
	    public WebMvcConfigurerAdapter corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	            }
	        };
	    }
	}


	
	
	
	             //         ------------------    DEBUT ADMIN CATALOGUE      ------------------         //
	            //                                ---------------------                                //
               //                                 ---------------------                               //
	
	
	
	 @GetMapping("/admin/catalogue")
	 public String adminCatalogue(Model model)
	 {
		 model.addAttribute("catalogue", cataloguerepo.findAll());
		 
		 return "catalogue";
	 }
	 
	 
	 @ResponseBody
	 @GetMapping("/catalogue")
	 public List<Catalogue> AllCatalogue()
	 {
		 Iterable<Catalogue> c = cataloguerepo.findAll();
		 
		 return (List<Catalogue>) c;
	 }
	 
	 
	 
	 @PostMapping("/admin/save/catalogue")
	 public String saveCatalogue(Model model, Catalogue catalogue)
	 {
		 cataloguerepo.save(catalogue);
		 
		 return adminCatalogue(model);
	 }
	 
	 
	 @GetMapping("/admin/delete/catalogue")
	 public String deleteCatalogue(long id, Model model)
	 {
		 cataloguerepo.deleteById(id);
		 
		 return adminCatalogue(model);
	 }
	 
	 
	 
		@RequestMapping(value = "/admin/edit/catalogue", method = {RequestMethod.GET, RequestMethod.POST})
		public String editPilote(Model model,  long id)
		{
			model.addAttribute("catalogue", cataloguerepo.findCatalogueById(id));
			
			return "editcatalogue";
		}
	 
	
	  //         ------------------    FIN ADMIN CATALOGUE      ------------------          //
     //                                ---------------------                                //
    //                                 ---------------------                               //
		
		
		
		
		
		// _______________________________________ ------------------- _________________________________ //
		
		// _______________________________________ ------------------- _________________________________ //
			
		
		
		
		 
         //         ------------------    DEBUT ADMIN FILM      ------------------              //
        //                                ---------------------                                //
       //                                 ---------------------                               //
		
		@GetMapping("/admin/film")
		public String GetAdminFilmPage(Model model)
		{
			model.addAttribute("film", filmrepo.findAll());
			
			return "film";
		}
		
		
		@ResponseBody
		@GetMapping("/film")
		public List<Film> GetAllFilm()
		{
			Iterable<Film> f = filmrepo.findAll();
			
			return (List<Film>) f;
		}
		
		
		
		 @PostMapping("/admin/save/film")
		 public String saveFilm(Model model, Film film)
		 {
			 filmrepo.save(film);
			 
			 return GetAdminFilmPage(model);
		 }
		 
		 
		 @GetMapping("/admin/delete/film")
		 public String deleteFilm(long id, Model model)
		 {
			 filmrepo.deleteById(id);
			 
			 return GetAdminFilmPage(model);
		 }
		 
		 
		 
			@RequestMapping(value = "/admin/edit/film", method = {RequestMethod.GET, RequestMethod.POST})
			public String editFilm(Model model,  long id)
			{
				model.addAttribute("film", filmrepo.findCatalogueById(id));
				
				return "editfilm";
			}
		
		
		
	
      //      ------------------         FIN ADMIN FILM      ------------------              //
     //                                ---------------------                                //
    //                                 ---------------------                               //
	
			
			
		
			
			
			
			
			
			
			// _______________________________________ ------------------- _________________________________ //
			
			// _______________________________________ ------------------- _________________________________ //
			
			
			
			
			

	         //         ------------------    DEBUT ADMIN CLIENT      ------------------              //
	        //                                ---------------------                                //
	       //                                 ---------------------                               //
			
			
			@GetMapping("/admin/client")
			public String GetAdminClientPage(Model model)
			{
				model.addAttribute("client", clientrepo.findAll());
				
				return "client";
			}
			
			
			@ResponseBody
			@GetMapping("/client")
			public List<Client> GetAllClient()
			{
				Iterable<Client> clients = clientrepo.findAll();
				
				return (List<Client>) clients;
			}
			
			
			
			 @PostMapping("/admin/save/client")
			 public String saveClient(Model model, Client client)
			 {
				 clientrepo.save(client);
				 
				 return GetAdminClientPage(model);
			 }
			 
			 
			 @GetMapping("/admin/delete/client")
			 public String deleteClient(long id, Model model)
			 {
				 clientrepo.deleteById(id);
				 
				 return GetAdminClientPage(model);
			 }
			 
			 
			 
				@RequestMapping(value = "/admin/edit/client", method = {RequestMethod.GET, RequestMethod.POST})
				public String editClient(Model model,  long id)
				{
					model.addAttribute("client", clientrepo.findCatalogueById(id));
					
					return "editclient";
				}
			
			
			
		
	      //      ------------------         FIN ADMIN CLIENT     ------------------              //
	     //                                ---------------------                                //
	    //                                 ---------------------                               //
			
			
				
				
				
				
				
				
				
				
				
				// _______________________________________ ------------------- _________________________________ //
				
				// _______________________________________ ------------------- _________________________________ //
				
				
				
				
				

		         //         ------------------    DEBUT ADMIN LANGUE      ------------------              //
		        //                                ---------------------                                //
		       //                                 ---------------------                               //
				
				
				@GetMapping("/admin/langue")
				public String GetAdminLanguePage(Model model)
				{
					model.addAttribute("langue", languerepo.findAll());
					
					return "langue";
				}
				
				
				@ResponseBody
				@GetMapping("/langue")
				public List<Langue> GetAllLangue()
				{
				
					Iterable<Langue> langues = languerepo.findAll();
					
					return (List<Langue>) langues;
				}
				
				
				
				 @PostMapping("/admin/save/langue")
				 public String saveLangue(Model model, Langue langue)
				 {
					 languerepo.save(langue);
					 
					 return GetAdminLanguePage(model);
				 }
				 
				 
				 @GetMapping("/admin/delete/langue")
				 public String deleteLangue(long id, Model model)
				 {
					 languerepo.deleteById(id);
					 
					 return GetAdminLanguePage(model);
				 }
				 
				 
				 
					@RequestMapping(value = "/admin/edit/langue", method = {RequestMethod.GET, RequestMethod.POST})
					public String editLangue(Model model,  long id)
					{
						model.addAttribute("langue", languerepo.findLangueById(id));
						
						return "editlangue";
					}
					
					
					
					@RequestMapping(value = "details/langue", method = {RequestMethod.GET})
					public String detailsLangue(Model model,  long id)
					{
						
						model.addAttribute("langue", languerepo.findLangueById(id));
						model.addAttribute("langue", languerepo.findAll());
					
						return "langue";
					}

				
				
				
			
		      //      ------------------         FIN ADMIN LANGUE     ------------------              //
		     //                                ---------------------                                //
		    //                                 ---------------------                               //
}








