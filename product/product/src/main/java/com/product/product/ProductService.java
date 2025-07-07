package com.product.product;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	@Autowired
	ProductRepository repo;
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	public Product getProductById(Integer id) {
		logger.info("ProductService::getProductById");
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"+id));
	}
	public String createProduct(Product p) {
		logger.info("ProductService::createProduct");
		if(repo.existsById(p.getId())) {
			throw new DuplicateResourceException("Product Already Exists"+p.getId());
		}else {
		 repo.save(p);
		 return "Product Added";
		}
	}
	public String deleteProduct(Integer id) {
		Product existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot Update.Product Not Found"+id));
		repo.delete(existing);
		return "Product Deleted";
	}
	public String updateProduct(Integer id,Product p) {
		Product prod =repo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Cannot Uodate.Product Not Found"+id));
		    if(p.getName() !=null) {
		    	prod.setName(p.getName());
		    }
		    if(p.getCategory()!=null) {
		    	prod.setCategory(p.getCategory());
		    }
		    if(p.getQty() !=null) {
		    	prod.setQty(p.getQty());
		    }
			repo.save(prod);
			return "Product Updated";
		
	}
}
