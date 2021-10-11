package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		/*System.out.println("*** SELLER ***");
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
		seller = sellerDao.findById(2);
		seller.setName("Tiago Correa");
		
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete ===");	
		System.out.print("Enter id for deletion: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);	
		
		System.out.println("Deletion completed");*/

		System.out.println();
		System.out.println("*** DEPARTMENT ***");
		System.out.println("=== TEST 1: findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: findAll ===");		
		List<Department> departmentList = departmentDao.findAll();
		
		for (Department dep : departmentList) {
			System.out.println(dep);			
		}
		
		System.out.println("\n=== TEST 5: update ===");		
		department = departmentDao.findById(2);
		department.setName("Zoo");
		
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: delete ===");	
		System.out.print("Enter id for deletion: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);	
		
		System.out.println("Deletion completed");
		
		System.out.println("\n=== TEST 7: insert ===");
		department = new Department(null, "Zoo2");
		departmentDao.insert(department);	
		
		System.out.println("New department " + department.getName() + " added");

		
		sc.close();
	}
}
