package net.javaguides.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.spring.model.Employee;
import net.javaguides.spring.repository.EmployeeRepository;
import net.javaguides.spring.model.Assest;
import net.javaguides.spring.repository.AssestRepository;

@SpringBootApplication
public class EmployeeManagmentApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagmentApplication.class, args);
	}

	

	@Autowired 
	private EmployeeRepository employeeRepository;

	@Autowired 
	private AssestRepository assestRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
//		Employee employee = new Employee();
//		employee.setFirstName("Ramesh");
//		employee.setLastname("Singh");
//		employee.setEmailId("ramesh123@gmail.com");
//		employeeRepository.save(employee);
//		
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Anchal");
//		employee1.setLastname("Singh");
//		employee1.setEmailId("anchal123@gmail.com");
//		employeeRepository.save(employee1);
//		
//		Employee employee2 = new Employee();
//		employee2.setFirstName("Shruti");
//		employee2.setLastname("Singh");
//		employee2.setEmailId("shruti123@gmail.com");
//		employeeRepository.save(employee2);
//		
////		
	}

}
