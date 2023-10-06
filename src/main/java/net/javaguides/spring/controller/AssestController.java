package net.javaguides.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.spring.exception.ResourceNotFoundException;
import net.javaguides.spring.model.Assest;
import net.javaguides.spring.repository.AssestRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/Assests")
public class AssestController {

	@Autowired 
	private AssestRepository AssestRepository;
	
	@GetMapping
	public List<Assest> getAllAssest(){
		return AssestRepository.findAll();
	}
	
		//Build create Assest Rest Api
	
		@PostMapping
		public Assest createAssest(@RequestBody Assest Assest)
		{
			return AssestRepository.save(Assest);
		}
		
		
		//build get Assest by id Rest Api
		
		@GetMapping("{id}")
		public ResponseEntity<Assest> getAssestById(@PathVariable long id){
			Assest Assest = AssestRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Assest does not exist with id: "+id));
			
			return ResponseEntity.ok(Assest);
		}
		
		
		//build update Assest rest api
		@PutMapping("{id}")
		public ResponseEntity<Assest> updateAssest(@PathVariable long id,@RequestBody Assest AssestDetails){
			Assest updateAssest = AssestRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Assest does not exist with id: "+id));
			
			updateAssest.setFirstName(AssestDetails.getFirstName());
			updateAssest.setAssest(AssestDetails.getAssest());	
			updateAssest.setLocation(AssestDetails.getLocation());
			
			
			AssestRepository.save(updateAssest);
			
			return ResponseEntity.ok(updateAssest);
			
			
		}
		
		//build delete Assest rest api
		@DeleteMapping("{id}")
		public ResponseEntity<HttpStatus> deleteAssest(@PathVariable long id){
			Assest Assest = AssestRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Assest does not exist with id: "+id));
			
			AssestRepository.delete(Assest);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		@PostMapping("/clone/{id}")
		public ResponseEntity<Assest> cloneAssest(@PathVariable long id){
			
			Assest clone = AssestRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Assest does not exist with id: "+id));
			
			Assest newAssest = new Assest();
			newAssest.setFirstName(clone.getFirstName());
			newAssest.setAssest(clone.getAssest());
			newAssest.setLocation(clone.getLocation());
			
			AssestRepository.save(newAssest);
			return ResponseEntity.ok(newAssest);
			
		}
		
		@GetMapping("/get-count-by-firstName")
		public ResponseEntity<List<Object>> countAssest(){
			List<Object> obj = AssestRepository.findNamesWithCounts();
			
			return ResponseEntity.ok(obj);
		}
		
		@GetMapping("/get-count-by-name")
		public ResponseEntity<List<Object>> countByName(){
			List<Object> obj = AssestRepository.findCounts();
			
			return ResponseEntity.ok(obj);
		}
		
		@GetMapping("/check/{id}")
		public ResponseEntity<Long> checkByName(@PathVariable long id ){
			
			Assest clone = AssestRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Assest does not exist with id: "+id));
			
			
			long name = AssestRepository.countByFirstName(clone.getFirstName());
		
			return ResponseEntity.ok(name);
		}
		
}
