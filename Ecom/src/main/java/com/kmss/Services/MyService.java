package com.kmss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmss.Dao.ApprovalDao;
import com.kmss.Dao.ProductDao;
import com.kmss.Entity.Approval;
import com.kmss.Entity.Products;

@Component
public class MyService {
	@Autowired
	private ProductDao pr;
	@Autowired
	private ApprovalDao ap;

	public List<Products> getproducts() {
		List<Products> list = (List<Products>) pr.findAll();
		return list;
	}
	public List<Approval> ListApprovals(){
		List<Approval> list =(List<Approval>) ap.findAll();
		return list;
	}
	public String SaveProduct(Products p) {
		if (p.getPrice() > 5000 && p.getPrice() <= 10000) {
			Approval a = new Approval(p.getId(), p.getName(), p.getPrice(),p.getStatus());
			ap.save(a);
			return "Waiting for the admin Approvial";
		} else if (p.getPrice() > 0 && p.getPrice() <= 5000) {
			pr.save(p);
			return "";
		}
		if (p.getPrice() < 0) {
			return "Price must not be less the 1";
		} else {
			return "price should be more than 10000";
		}
	}

	public Products GetProductById(int i) {
		Products p = pr.findById(i);
		return p;
	}
	public String Appverify(int aid) {
		if(!ap.existsById(aid)) {
			return "No record found";
		}
		Approval p = ap.findById(aid);
		if(p.getStatus().equalsIgnoreCase("delete")) {
			pr.deleteById(p.getId());
			ap.deleteById(aid);
			return "deleted";
		}
		Products mp=new Products(p.getName(), p.getPrice(), "Available");
		if(p.getId()==0) {
			pr.save(mp);
			
		}else {
			mp.setId(p.getId());
			pr.save(mp);
		}
		ap.deleteById(aid);
		return "Record Updated in Products database";
	}

	public String Delete(int i) {
		if(!pr.existsById(i)) {
			return "No Record found";
		}
		Products p = pr.findById(i);
		Approval a = new Approval(p.getId(), p.getName(), p.getPrice(), "Delete");
		ap.save(a);
		return "Waiting for admin";
	}
	public String AppReject(int i) {
		if(ap.existsById(i)) {
			ap.deleteById(i);
			return "Rejected";
		}
		return "No record Found";
	}

	public String Update(Products p, Products old) {
		if (p.getPrice() > 1.5 * old.getPrice()) {
			Approval a = new Approval(p.getId(), p.getName(), p.getPrice(), "Update");
			ap.save(a);
			return "Waiting for the Admin Approval";
		} else {
			pr.save(p);
			return "updated";
		}
	}

}
