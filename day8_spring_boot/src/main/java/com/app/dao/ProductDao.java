package com.app.dao;

import java.util.List;

import com.app.pojos.Product;

public interface ProductDao {
	
	List<Product> getProductByCategoryName(String categoryName);

}
