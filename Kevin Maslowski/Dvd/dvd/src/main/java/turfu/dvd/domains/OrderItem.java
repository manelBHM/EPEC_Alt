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
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long OrderItemId;
	@ManyToOne(targetEntity = Dvd.class)
	@JoinColumn(name = "dvd_id")
	Dvd dvd;
	long quantity;
	@ManyToOne(targetEntity = Orderz.class)
	@JoinColumn(name = "Order_id")
	Orderz order;
	
}
