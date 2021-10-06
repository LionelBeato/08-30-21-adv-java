package com.tts.ecommerce.repository;

import com.tts.ecommerce.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // note that we can define methods in our repository interface
    // and depending on the name and annotations used, the functionality will
    // be interpreted by our JPA layer
    List<Product> findAll();
    Product findById(long id);
    List<Product> findByBrand(String brand);
    List<Product> findByCategory(String category);
    List<Product> findByBrandAndCategory(String brand, String category);

    @Query("SELECT DISTINCT p.brand FROM Product p")
    List<String> findDistinctBrands();

    @Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findDistinctCategories();



}
