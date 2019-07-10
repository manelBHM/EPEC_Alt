package videofutur.dvd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import videofutur.dvd.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
