package com.example.montestore;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
//Needs work
@Entity(tableName = "cart",        foreignKeys = @ForeignKey(entity = ProductEntity.class,
        parentColumns = "id",
        childColumns = "product_id",
        onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = {"product_id"})})
public class CartEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "product_id")
    private int productId;

    @ColumnInfo(name = "quantity")
    private int quantity;

    public CartEntity(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
