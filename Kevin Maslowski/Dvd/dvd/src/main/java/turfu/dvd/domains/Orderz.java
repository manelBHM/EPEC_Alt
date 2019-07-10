package turfu.dvd.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orderz {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long OrderId;
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name="customer_id")
	Customer customer;
	long nbrDvd;
	String date;
	double totalPrice;
}

