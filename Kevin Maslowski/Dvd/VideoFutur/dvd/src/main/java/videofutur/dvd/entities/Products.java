package videofutur.dvd.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String title;
//	@ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="category_id")
	Long categoryId;
	String description;
	Long price;
	Long mostRented;
	Long stock;

}
