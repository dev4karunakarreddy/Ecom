package com.kmss.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmss.Entity.Approval;
import com.kmss.Entity.Products;
import com.kmss.Services.MyService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class MyController {
	@Autowired
	private MyService my;
	@GetMapping("/api/products")
	public List<Products> getproducts() {
		System.out.println(my.getproducts());
		return my.getproducts();
	}
	@PostMapping("/api/products")
	public String Create(@RequestBody Products p) {
		return my.SaveProduct(p);
	}
	
	@GetMapping("/api/products/{id}")
	public Products GetProductById(@PathVariable("id") int id) {
		return my.GetProductById(id);
	}
	
	@DeleteMapping("/api/products/{id}")
	public String Delete(@PathVariable("id") int id) {
		return my.Delete(id);
	}
	@PutMapping("/api/products")
	public String Update(@RequestBody Products pr) {
		Products old=GetProductById(pr.getId());
		return my.Update(pr,old);
	}
	@GetMapping("/api/products/approval-queue")
	public List<Approval> ApprovalList() {
		return my.ListApprovals();
	}
	@PutMapping("/api/products/approval-queue/{aid}/approve")
	public String Verify(@PathVariable("aid") int aid) {
		return my.Appverify(aid);
	}
	@PutMapping("/api/products/approval-queue/{id}/reject")
	public String Reject(@PathVariable("id") int id) {
		return my.AppReject(id);
	}
}
