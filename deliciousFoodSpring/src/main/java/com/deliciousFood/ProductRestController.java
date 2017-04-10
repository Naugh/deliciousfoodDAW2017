package com.deliciousFood;

import java.util.List;

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
@RequestMapping("/api/products")
public class ProductRestController {

	

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserService userService;
	
	//Devuelve los productos del restaurante con ese id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(@PathVariable long id){
		Restaurant r = restaurantRepository.findById(id);
		if (r != null) {			
			return new ResponseEntity<>(r.getProducts(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// Añade los productos al restaurante logeado
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
		if (userService.isLoggedUser()) {
			Restaurant r = restaurantRepository.findById((userService.getRestaurant().getId()));		
			//Elimina productos existentes
			for(int i = 0; i < r.getProducts().size();i++){
				boolean exist = false;
				for(int j = 0; j< products.size() && !exist; j++){
					if(r.getProducts().get(i).getId() == products.get(j).getId()){
						exist = true;
					}
				}
				if(!exist){
					productRepository.delete(r.getProducts().get(i));
					r.getProducts().remove(i);
					i--;
				}
			}		
			for(int i = 0; i<products.size();i++){
				Product pReceived = products.get(i);
				Product pRestaurant = r.getProductById(pReceived.getId());	
				//Actualiza productos existentes
				if(pRestaurant!=null && !pReceived.equals(pRestaurant)){
					r.setProductById(pReceived.getId(), pReceived);
				//Añade productos nuevos
				}else if(pRestaurant==null){
					r.getProducts().add(pReceived);
					productRepository.save(pReceived);
				}
			}			
			restaurantRepository.save(r);
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	//Devuelve los productos del restaurante logeado
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getMyProducts(){		
		if (userService.isLoggedUser()){	
			Restaurant r = restaurantRepository.findById((userService.getRestaurant().getId()));
			List<Product> products = r.getProducts();	
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
}
