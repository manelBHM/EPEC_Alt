package avions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import avions.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	

}
