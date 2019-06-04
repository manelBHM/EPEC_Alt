package org.openup.pilotes.avions.vols.dao.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openup.pilotes.Pilotes;
import org.openup.pilotes.avions.vols.dao.DAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	private static List<Pilotes> P = new ArrayList<Pilotes>();
	DAO AO = new DAO();
	
	@GetMapping("/home")
	public String test(Model model) throws ClassNotFoundException, SQLException {
		P=AO.getAll();
		model.addAttribute("P", P);

		return "home";
	}
	

}
