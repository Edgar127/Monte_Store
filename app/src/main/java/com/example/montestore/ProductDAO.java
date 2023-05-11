package com.example.montestore;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM products")
    List<ProductEntity> getAllProducts();

    @Insert
    void insertProduct(ProductEntity product);

    @Query("DELETE FROM products")
    void deleteAllProducts();

    @Query("DELETE FROM products WHERE id = :productId")
    void deleteProductById(int productId);
}
