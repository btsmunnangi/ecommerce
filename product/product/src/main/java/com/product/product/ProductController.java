package com.product.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	ProductService service;
	@GetMapping
   public ResponseEntity<List<Product>> getAllProducts(){
	   return new ResponseEntity<List<Product>>(service.getAllProducts(),HttpStatus.OK);
   }
	@GetMapping("/{id}")
   public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
	   return new ResponseEntity<Product>(service.getProductById(id),HttpStatus.OK);
   }
	@PostMapping
   public ResponseEntity<String> createProduct(@RequestBody Product prod) {
	   return new ResponseEntity<String>(service.createProduct(prod),HttpStatus.CREATED);
   }
	@DeleteMapping("/{id}")
   public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
	   return new ResponseEntity<String>(service.deleteProduct(id),HttpStatus.OK);
   }
	@PutMapping("/{id}")
   public ResponseEntity<String> updateProduct(@PathVariable Integer id,@RequestBody Product prod) {
	   return new ResponseEntity<String>(service.updateProduct(id, prod),HttpStatus.OK);
   }
}
