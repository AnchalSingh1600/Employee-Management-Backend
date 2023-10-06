package net.javaguides.spring.repository;

//import java.util.List;
//import java.util.Map;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import net.javaguides.spring.model.Employee;
//
//public interface EmployeeRepository extends JpaRepository<Employee,Long>{
//
//	@Query("SELECT first_name, COUNT(*) as name_count "
//		       + "FROM Employee "
//		       + "GROUP BY first_name")
//		List<Map<String,dynamic>> findNamesWithCounts();
//
//}

import java.util.List; 
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query("SELECT first_name, COUNT(*) as name_count "
//           + "FROM Employee "
//           + "GROUP BY first_name")
//    List<Map<String, Object>> findNamesWithCounts();
	
	@Query("SELECT e.firstName, COUNT(e) as name_count FROM Employee e GROUP BY e.firstName")
	List<Object> findNamesWithCounts();

	@Query("SELECT COUNT(e) as name_count FROM Employee e GROUP BY e.firstName ")
	List<Object> findCounts();
	
	
	long countByFirstName(String firstName);
}
