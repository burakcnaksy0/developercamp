package com.burakcanaksoy.developercamp.dataAccess.abstracts;

import com.burakcanaksoy.developercamp.entities.concretes.Product;
import com.burakcanaksoy.developercamp.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    // JPA
    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName , int categoryId);
    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);
    List<Product> getByProductNameEndsWith(String productName);


    // Jpql
    @Query("FROM Product p where p.productName=:productName and p.category.categoryId=:categoryId")
    List<Product> getByNameAndCategoryId(String productName, int categoryId);

    @Query("Select new com.burakcanaksoy.developercamp.entities.dtos.ProductWithCategoryDto(p.productId,p.productName,c.categoryName) from Category c inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}

