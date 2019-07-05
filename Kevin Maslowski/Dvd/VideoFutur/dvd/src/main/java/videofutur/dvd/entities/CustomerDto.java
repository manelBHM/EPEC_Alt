package videofutur.dvd.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	Long id;
	String firstName;
	String lastName;
	String password;
	String adress;
	List<Orders> orders;

	public Customer toCustomer(CustomerDto customerDto) {

		Customer newCustomer = new Customer();
		newCustomer.setId(customerDto.getId());
		newCustomer.setFirstName(customerDto.getFirstName());
		newCustomer.setLastName(customerDto.getLastName());
		newCustomer.setAdress(customerDto.getAdress());
		newCustomer.setPassword(customerDto.getPassword());

		return newCustomer;

	}

}
