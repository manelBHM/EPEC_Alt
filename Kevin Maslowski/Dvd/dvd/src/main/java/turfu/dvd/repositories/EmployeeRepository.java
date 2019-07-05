package turfu.dvd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import turfu.dvd.domains.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
