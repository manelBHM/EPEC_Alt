package turfu.dvd.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dvd {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long DvdId;
	double price;
	int category;
	String name;
	String photo;
	int view;
	long stock;
	
}
