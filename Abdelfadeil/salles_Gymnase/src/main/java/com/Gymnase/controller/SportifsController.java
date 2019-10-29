package com.Gymnase.controller;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.Gymnase.entities.Sportifs;
import com.Gymnase.entities.Roles;
import com.Gymnase.services.RoleService;
import com.Gymnase.services.SportifsService;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/user/*")
public class SportifsController {

	    private static final Logger logger = LoggerFactory.getLogger(SportifsController.class);

	    @Autowired
	    private SportifsService sportifsService;    
	    @Autowired
	    private RoleService roleService;
	    
	    @GetMapping(value = "/users")
	    public ResponseEntity<Collection<Sportifs>> getAllUsers() {
	        Collection<Sportifs> sportifs = sportifsService.getAllSportifs();
	        logger.info("liste des utilisateurs : " + sportifs.toString());
	        return new ResponseEntity<Collection<Sportifs>>(sportifs, HttpStatus.FOUND);
	    }

	    private Set<Roles> extractRole_Java8(Set<Roles> rolesSetFromUser, Stream<Roles> roleStreamFromDB) {         
	     // Collect UI role names
	         Set<String> uiRoleNames = rolesSetFromUser.stream()
	             .map(Roles::getRoleName)
	             .collect(Collectors.toCollection(HashSet::new));
	     // Filter DB roles
	        return roleStreamFromDB
	            .filter(role -> uiRoleNames.contains(role.getRoleName()))
	            .collect(Collectors.toSet());
	    }

	    private Set<Roles> extractRoleUsingCompareTo_Java8(Set<Roles> rolesSetFromUser, Stream<Roles> roleStreamFromDB) {
	        return roleStreamFromDB
	            .filter(roleFromDB -> rolesSetFromUser.stream()
	            .anyMatch( roleFromUser -> roleFromUser.compareTo(roleFromDB) == 0))
	            .collect(Collectors.toCollection(HashSet::new));
	    }

	    private Set<Roles>  extractRole_BeforeJava8(Set<Roles> rolesSetFromUser, Collection<Roles> rolesFromDB) {
	        Set<Roles> rolesToAdd = new HashSet<>();
	        for(Roles roleFromUser:rolesSetFromUser){
	            for(Roles roleFromDB:rolesFromDB){
	                if(roleFromDB.compareTo(roleFromUser)==0){
	                    rolesToAdd.add(roleFromDB);
	                    break;
	                }
	            }
	        }
	        return rolesToAdd;
	    }

		public RoleService getRoleService() {
			return roleService;
		}

		public void setRoleService(RoleService roleService) {
			this.roleService = roleService;
		}
		@GetMapping(value = "/users/{loginName}")
		public ResponseEntity<Sportifs> findUserByLogin(@PathVariable("loginName") String login) {
			Sportifs sportifs = sportifsService.findByLogin(login);
		    logger.debug("Utilisateur trouvé : " + sportifs);
		    return new ResponseEntity<Sportifs>(sportifs, HttpStatus.FOUND);
		}
		@PutMapping(value = "/users/{id}")
	    public ResponseEntity<Sportifs> updateUser(@PathVariable(value = "id") Long id, @RequestBody Sportifs sportifs) {
	        
			Sportifs sportifsToUpdate = sportifsService.getSportifsById(id);
	        if (sportifsToUpdate == null) {
	            logger.debug("L'utilisateur avec l'identifiant " + id + " n'existe pas");
	            return new ResponseEntity<Sportifs>(sportifs,HttpStatus.NOT_FOUND);
	        } 
	        
	        logger.info("UPDATE ROLE: "+sportifsToUpdate.getRoles().toString());
	        sportifsToUpdate.set_id(sportifs.get_id());
	        sportifsToUpdate.setIdSportif(sportifs.getIdSportif());
	        sportifsToUpdate.setNom(sportifs.getNom());
	        sportifsToUpdate.setPrenom(sportifs.getPrenom());
	        sportifsToUpdate.setSexe(sportifs.getSexe());
	        sportifsToUpdate.setAge(sportifs.getAge());
	        Sportifs sportifsUpdated = sportifsService.saveOrUpdateSportifs(sportifsToUpdate);
	        return new ResponseEntity<Sportifs>(sportifsUpdated, HttpStatus.OK);
	    }

	    @DeleteMapping(value = "/users/{id}")
	    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
	    	sportifsService.deleteById(id);
	    return new ResponseEntity<Void>(HttpStatus.GONE);
	     }
	}

