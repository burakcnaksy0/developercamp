package com.burakcanaksoy.developercamp.business.concretes;

import com.burakcanaksoy.developercamp.business.abstracts.ProductService;
import com.burakcanaksoy.developercamp.core.utilities.results.*;
import com.burakcanaksoy.developercamp.dataAccess.abstracts.CategoryDao;
import com.burakcanaksoy.developercamp.dataAccess.abstracts.ProductDao;
import com.burakcanaksoy.developercamp.entities.concretes.Category;
import com.burakcanaksoy.developercamp.entities.concretes.Product;
import com.burakcanaksoy.developercamp.entities.dtos.ProductWithCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productDao.findAll(), "All products found");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<>(productDao.findAll(pageable).getContent(), "All products found");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<>(productDao.findAll(sort), "All products found");
    }

    @Override
    public DataResult<Product> getProductById(int productId) {
        Product product =  productDao.findById(productId).get();
        return new SuccessDataResult<>(product, "Product found");
    }

    @Override
    public Result addProduct(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product added successfully");
    }

    @Override
    public Result deleteProduct(int productId) {
        this.productDao.deleteById(productId);
        return new SuccessResult("Product deleted successfully");
    }

    @Override
    public DataResult<Product> updateProduct(int productId, Product product) {
        Optional<Product> optionalProduct = productDao.findById(productId);

        if (optionalProduct.isPresent()) {
            Product dbProduct = optionalProduct.get();

            dbProduct.setProductName(product.getProductName());
            dbProduct.setUnitPrice(product.getUnitPrice());
            dbProduct.setUnitsInStock(product.getUnitsInStock());
            dbProduct.setQuantityPerUnit(product.getQuantityPerUnit());

            // Category Update
            int newCategoryId = product.getCategory().getCategoryId();
            Category newCategory = categoryDao.findById(newCategoryId).orElseThrow(()-> new RuntimeException("Category not found"));
            dbProduct.setCategory(newCategory);

            Product updatedProduct = productDao.save(dbProduct);

            return new SuccessDataResult<>(updatedProduct, "Product updated successfully");
        }

        return new ErrorDataResult<>("Product not found");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductName(productName),"Product found");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),"Product found");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Products found");
    }

    @Override
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<>(this.productDao.getByCategory_CategoryIdIn(categories),"Products found");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameContains(productName),"Products found");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameStartsWith(productName),"Products found");
    }

    @Override
    public DataResult<List<Product>> getByProductNameEndsWith(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameEndsWith(productName),"Products found");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
        List<Product> products = this.productDao.getByNameAndCategoryId(productName, categoryId);
        if(products.isEmpty()){
            return new ErrorDataResult<>("Product not found");
        }
        return new SuccessDataResult<>(this.productDao.getByNameAndCategoryId(productName, categoryId),"Products found");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<>(this.productDao.getProductWithCategoryDetails(),"Products found");
    }


}
