package com.Gymnase.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Utilisateur {
	
	@Id
	private String id;
	private String userName;
	private String password;
	@DBRef
	private Collection<Roles> roles = new ArrayList<Roles>();
	

}
