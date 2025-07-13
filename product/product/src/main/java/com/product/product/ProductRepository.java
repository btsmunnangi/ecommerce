package com.product.product;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{
	public Product findProductByName(String name);
    public List<Product> findProductByQtyGreaterThan(int qty);
    public List<Product> findProductByQty(int qty);
    public List<Product> findProductByNameAndQty(String name,int qty);
    public List<Product> findProductByQtyLessThan(int qty);
    public long countByName(String name);
    public long countByQty(int qty);
}
