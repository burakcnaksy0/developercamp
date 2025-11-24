package com.burakcanaksoy.developercamp.api.controllers;

import com.burakcanaksoy.developercamp.business.abstracts.ProductService;
import com.burakcanaksoy.developercamp.core.utilities.results.DataResult;
import com.burakcanaksoy.developercamp.core.utilities.results.Result;
import com.burakcanaksoy.developercamp.entities.concretes.Product;
import com.burakcanaksoy.developercamp.entities.dtos.ProductWithCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/get/all")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/get/page-all")
    public DataResult<List<Product>> getAll(int pageNo , int pageSize){
        return productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/get/sorted-all")
    public DataResult<List<Product>> getAllSorted(){
        return productService.getAllSorted();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return productService.getProductWithCategoryDetails();
    }

    @GetMapping("/get/by/{productId}")
    public DataResult<Product> getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public Result deleteProduct(@PathVariable("productId") int productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping("/update/{productId}")
    public Result updateProduct(@RequestBody Product product, @PathVariable("productId") int productId){
        return productService.updateProduct(productId, product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam("productName") String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory_CategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameOrCategory_CategoryId")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return productService.getByProductNameOrCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getByCategory_CategoryIdIn")
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories){
        return productService.getByCategory_CategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName){
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam("productName") String productName){
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByProductNameEndsWith")
    public DataResult<List<Product>> getByProductNameEndsWith(@RequestParam("productName") String productName){
        return productService.getByProductNameEndsWith(productName);
    }

    @GetMapping("/getByNameAndCategoryId")
    public DataResult<List<Product>> getByNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return productService.getByNameAndCategoryId(productName,categoryId);
    }


}