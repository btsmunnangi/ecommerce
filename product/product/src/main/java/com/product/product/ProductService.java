package com.product.product;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	@Autowired
	ProductRepository repo;
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	public Page<Product> getAllProducts(int pageNumber,int pageSize,String sortBy){
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		return repo.findAll(pageable);
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
	public Product findProductByName(String name) {
		Product p= repo.findProductByName(name);
		if(Objects.isNull(p)){
			throw new ResourceNotFoundException("Product Not Found with Name:"+name);
		}
		return p;
	}
	public List<Product> findProductByQty(Integer qty) {
		List<Product> plist= repo.findProductByQty(qty);
		System.out.println(plist);
		if(plist==null||plist.isEmpty()){
			throw new ResourceNotFoundException("Product Not Found with Qty:"+qty);
		}
		return plist;
	}
	public List<Product> findProductByNameAndQty(String name,Integer qty) {
		List<Product> plist= repo.findProductByNameAndQty(name, qty);
		if(plist==null||plist.isEmpty()){
			throw new ResourceNotFoundException("Product Not Found with Name:"+name+"Qty:"+qty);
		}
		return plist;
	}
	public List<Product> findProductByQtyGreaterThan(Integer qty) {
		List<Product> plist= repo.findProductByQtyGreaterThan(qty);
		if(plist==null||plist.isEmpty()){
			throw new ResourceNotFoundException("Product Not Found with Qty Greater than:"+qty);
		}
		return plist;
	}
	public List<Product> findProductByQtyLessThan(Integer qty) {
		List<Product> plist= repo.findProductByQtyLessThan(qty);
		if(plist==null||plist.isEmpty()){
			throw new ResourceNotFoundException("Product Not Found with Qty Less than:"+qty);
		}
		return plist;
	}
}
