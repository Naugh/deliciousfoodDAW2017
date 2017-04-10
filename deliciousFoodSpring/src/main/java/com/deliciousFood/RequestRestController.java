package com.deliciousFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request")
public class RequestRestController {
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	 public Request addRequest(@RequestBody Request request) {
		
		
		requestRepository.save(request);		
		return request;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Request> getRequest(@PathVariable long id) {
			
		Request req =  requestRepository.findById(id);
		if (req != null){
			return new ResponseEntity<>(req, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Request> deleteRequest(@PathVariable long id) {
	
		Request req= requestRepository.findById(id);
		if (req != null){			
			requestRepository.delete(req);
			return new ResponseEntity<>(req, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	

}
