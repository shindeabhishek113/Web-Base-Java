package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private EntityManager manager;

	@Override
	public List<Product> getProductByCategoryName(String categoryName1) {
		
		String jpql="select p from Product p where p.productCategory.categoryName=:nm";
		return manager.createQuery(jpql,Product.class).
				setParameter("nm", categoryName1).getResultList();
	}
	

}
