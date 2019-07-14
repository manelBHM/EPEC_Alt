package com.example.dvdstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dvdstore.entity.Dvd;
import com.example.dvdstore.repo.DvdRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DvdService {

	@Autowired
	DvdRepo dvdRepo;
	
	public List<Dvd> showDvd() {
		return dvdRepo.findAll();
	}
	
	public Dvd createDvdd(Dvd dvd) {
		return dvdRepo.save(dvd);
	}
	
	public void deleteById(long id) {
		dvdRepo.deleteById(id);
	}
	
	public Dvd getOneDvd(long id) {
		Dvd dvd = dvdRepo.getOne(id);
		addOneView(dvd);
		return dvd;
	}
	
	public Dvd addOneView(Dvd dvd) {
		dvd.setVue(dvd.getVue() +1);
		dvdRepo.save(dvd);
		return dvd;
	}
}

