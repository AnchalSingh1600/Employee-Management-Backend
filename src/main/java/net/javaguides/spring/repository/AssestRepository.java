package net.javaguides.spring.repository;

//import java.util.List;
//import java.util.Map;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import net.javaguides.spring.model.Assest;
//
//public interface AssestRepository extends JpaRepository<Assest,Long>{
//
//	@Query("SELECT first_name, COUNT(*) as name_count "
//		       + "FROM Assest "
//		       + "GROUP BY first_name")
//		List<Map<String,dynamic>> findNamesWithCounts();
//
//}

import java.util.List; 
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.spring.model.Assest;

public interface AssestRepository extends JpaRepository<Assest, Long> {

//    @Query("SELECT first_name, COUNT(*) as name_count "
//           + "FROM Assest "
//           + "GROUP BY first_name")
//    List<Map<String, Object>> findNamesWithCounts();
	
	@Query("SELECT e.firstName, COUNT(e) as name_count FROM Assest e GROUP BY e.firstName")
	List<Object> findNamesWithCounts();

	@Query("SELECT COUNT(e) as name_count FROM Assest e GROUP BY e.firstName ")
	List<Object> findCounts();
	
	
	long countByFirstName(String firstName);
}
