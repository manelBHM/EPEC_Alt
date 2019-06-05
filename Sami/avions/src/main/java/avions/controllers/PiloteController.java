package avions.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import avions.model.Vol;
import avions.repository.PiloteRepository;
import avions.repository.VolRepository;

@Controller
//@RequestMapping(value = "/pilotes")
public class PiloteController {

	@Autowired
	PiloteRepository piloteRepository;
	@Autowired
	VolRepository volRepository;

}
