package com.Virtusa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class PaymentStatusController {

	@Autowired
	TransactionRepo transrepo;
	
	@Autowired
	AccountRepo accountrepo;
	
	@PostMapping("/get/{aid}/{tid}")
	public Optional<Transaction> getStatus(@PathVariable("aid") int aid,@PathVariable("tid") int tid) {
		
		Transaction t=new Transaction();
		
		t.setAccountFrom(0);
		t.setAccountTo(0);
		t.setClosing(0);
		t.setLdt(java.time.LocalDateTime.now());
		t.setOpening(0);
		t.setStatus(false);
		t.setTotal(0);
		t.setTransactionId(0);
		
		if(!accountrepo.existsById(aid)) {
			t.setTransStatus("Invalid Account Number");
			return Optional.of(t);
		}
		
		if(!transrepo.existsById(tid)) {
			t.setTransStatus("Invalid Transaction Number");
			return Optional.of(t);
		}
		return transrepo.findById(tid);
	}
}
