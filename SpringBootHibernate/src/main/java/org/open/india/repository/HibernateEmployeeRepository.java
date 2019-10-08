package org.open.india.repository;

import java.util.List;

import org.open.india.model.Employee;
import org.open.india.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HibernateEmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value= "SELECT * FROM USER_TABLE WHERE name = ?1 and password = ?2", nativeQuery = true)
	public List<User> find(@Param("name") String name, @Param("password") String password);
}
