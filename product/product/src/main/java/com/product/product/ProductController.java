package com.product.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@GetMapping
   public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable){
		Page<Product> pages = service.getAllProducts(0,5,"name");
		List<Product> list = pages.getContent();
		int count = pages.getTotalPages();
		logger.info("ProductController::getAllProducts::Total Pages{}:"+count);
		long elements = pages.getTotalElements();
		logger.info("ProductController::getAllProducts::Total Elements{}:"+elements);
		boolean hasNextPage = pages.hasNext();
		logger.info("ProductController::getAllProducts::hasNext:"+elements);
	    return new ResponseEntity<Page<Product>>(pages,HttpStatus.OK);
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
   @GetMapping("/productByName/{name}")	
   public ResponseEntity<Product> findProductByName(@PathVariable String name) {
	   return new ResponseEntity<Product>(service.findProductByName(name),HttpStatus.OK);
   }
   @GetMapping("/productByQty/{qty}")
   public ResponseEntity<List<Product>> findProductByQty(@PathVariable Integer qty){
	   return new ResponseEntity<List<Product>>(service.findProductByQty(qty),HttpStatus.OK);
   }
   @GetMapping("/productByNameQty/{name}/{qty}")
   public ResponseEntity<List<Product>> findProductByNameAndQty(@PathVariable String name,@PathVariable Integer qty){
	   return new ResponseEntity<List<Product>>(service.findProductByNameAndQty(name,qty),HttpStatus.OK);
   }
   @GetMapping("/productByQtyGreater/{qty}")
   public ResponseEntity<List<Product>> findProductByQtyGreaterThan(@PathVariable Integer qty){
	   return new ResponseEntity<List<Product>>(service.findProductByQtyGreaterThan(qty),HttpStatus.OK);
   }
   @GetMapping("/productByQtyLess/{qty}")
   public ResponseEntity<List<Product>> findProductByQtyLessThan(@PathVariable Integer qty){
	   return new ResponseEntity<List<Product>>(service.findProductByQtyLessThan(qty),HttpStatus.OK);
   }
   
}
