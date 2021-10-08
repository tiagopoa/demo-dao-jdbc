package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartmentId ===");
		Department dep = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDepartmentId(dep);
		
		for (Seller seller2 : sellerList) {
			System.out.println(seller2);			
		}	
		
		System.out.println("\n=== TEST 3: seller findAll ===");		
		sellerList = sellerDao.findAll();
		
		for (Seller seller2 : sellerList) {
			System.out.println(seller2);			
		}
		
		System.out.println("\n=== TEST 5: seller update ===");		
		seller = sellerDao.findById(1);
		seller.setName("Tiago Correa");
		
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		
	}
}
