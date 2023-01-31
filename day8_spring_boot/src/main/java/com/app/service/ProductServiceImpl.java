package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.app.dao.ProductDao;
import com.app.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao prodDao;

	@Override
	public List<Product> getProductByCategoryNmae(String categoryName) {
		
		
		return prodDao.getProductByCategoryName(categoryName);
	}
	
	

}
