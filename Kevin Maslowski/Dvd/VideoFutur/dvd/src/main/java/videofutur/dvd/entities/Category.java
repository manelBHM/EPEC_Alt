package videofutur.dvd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
public class Category {
	@Id
	Long id;
	String categoryName;
	@OneToMany(targetEntity = Products.class)
	@JoinColumn(name="products_id")
	List<Products>categoryProducts = new ArrayList<>();

}
