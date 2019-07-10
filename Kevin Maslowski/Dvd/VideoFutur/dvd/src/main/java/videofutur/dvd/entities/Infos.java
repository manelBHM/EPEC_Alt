package videofutur.dvd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Infos {

	@Id
	Long user_id;
	String firstName;
	String lastName;
	String adress;
	@OneToMany
	@JoinColumn(name="orders_id")
	List<Orders>orders = new ArrayList<>();
	@OneToOne
	@JoinColumn(name="cart_id")
	Cart cart;
	
	
}
