package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entity.Department;
import model.entity.Seller;

public class App {

	public static void main(String[] args) {		
		
		System.out.println("Seller findById");
		System.out.println("---------------");
		SellerDao sellerDao = DaoFactory.createSellerDao();		
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("Seller findByDepartment");
		System.out.println("---------------");
		Department dep = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(dep);		
		for(Seller s : sellers) {
			System.out.println(s);
		}
		
		System.out.println();		
		
		System.out.println("Seller findAll");
		System.out.println("---------------");		
		sellers = sellerDao.findAll();		
		for(Seller s : sellers) {
			System.out.println(s);
		}
		
		System.out.println();
		
		System.out.println("Seller Insertion");
		System.out.println("---------------");
		Seller insertSeller = new Seller(null, "Taise", "tata@gmail.com", new Date(), 10000.00, dep);
		sellerDao.insert(insertSeller);
		System.out.println("Inserted seller id " + insertSeller.getId());
		
		System.out.println();
		
		System.out.println("Seller Update");
		System.out.println("-------------");
		seller = sellerDao.findById(1);
		seller.setName("Marokas");
		sellerDao.update(seller);
		System.out.println(seller);
		
		
		System.out.println();
		
		System.out.println("Seller Update");
		System.out.println("-------------");
		sellerDao.deleteById(insertSeller.getId());
		
		

	}

}
