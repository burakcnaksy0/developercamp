package com.burakcanaksoy.developercamp.business.abstracts;

import com.burakcanaksoy.developercamp.core.utilities.results.DataResult;
import com.burakcanaksoy.developercamp.core.utilities.results.Result;
import com.burakcanaksoy.developercamp.entities.concretes.Product;
import com.burakcanaksoy.developercamp.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo , int pageSize);
    DataResult<List<Product>> getAllSorted();
    DataResult<Product> getProductById(int productId);
    Result addProduct(Product product);
    Result deleteProduct(int productId);
    DataResult<Product> updateProduct(int productId , Product product);
    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName , int categoryId);
    DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product>> getByProductNameEndsWith(String productName);
    DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}