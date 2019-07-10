package videofutur.dvd.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	
	//????????
	
	Long customerId;
	LocalDate date;
	double amount;
	@OneToMany(targetEntity = Products.class)
	@JoinColumn(name="cart_products")
	List <Products> productList = new ArrayList<>();
}
