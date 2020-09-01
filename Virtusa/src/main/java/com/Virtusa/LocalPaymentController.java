package com.Virtusa;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments") 
public class LocalPaymentController {
	
	private static final int max=9999;
	
	private static final int min=1000;
	
	@Autowired
	AccountRepo accrepo;
	
	@Autowired
	TransactionRepo transrepo;
	
	@PostMapping("/make/{sid}/{rid}/{amt}")
	public Optional<Transaction> doLocalpmt(@PathVariable("sid") int sid,@PathVariable("rid") int rid,@PathVariable("amt") int amt)
	{
		Account src;
		
		Account dest;
		
		Random rand=new Random();
		
		int tid =rand.nextInt((max-min)+1)+min;
		
		if(accrepo.existsById(sid)) {
			src=accrepo.getOne(sid);
		}
		else {
			Transaction t=new Transaction();
			t.setTransactionId(tid);
			t.setAccountFrom(sid);
			t.setAccountTo(rid);
			t.setStatus(false);
			t.setOpening(0);
			t.setClosing(0);
			t.setTotal(0);
			t.setLdt(java.time.LocalDateTime.now());
			t.setTransStatus("Bad Account Number");
			transrepo.save(t);
			return transrepo.findById(tid);
		}
		
		if(accrepo.existsById(rid)) {
			dest=accrepo.getOne(rid);
		}
		else {
			Transaction t=new Transaction();
			t.setTransactionId(tid);
			t.setAccountFrom(sid);
			t.setAccountTo(rid);
			t.setStatus(false);
			t.setOpening(0);
			t.setLdt(java.time.LocalDateTime.now());
			t.setClosing(0);
			t.setTotal(0);
			t.setTransStatus("Bad Account Number");
			transrepo.save(t);
			return transrepo.findById(tid);
		}
		
		if(!(src.getCountry().equals("IND"))||(!(dest.getCountry().equals("IND")))) {
			Transaction t=new Transaction();
			t.setTransactionId(tid);
			t.setAccountFrom(sid);
			t.setAccountTo(rid);
			t.setStatus(false);
			t.setOpening(0);
			t.setLdt(java.time.LocalDateTime.now());
			t.setClosing(0);
			t.setTotal(0);
			t.setTransStatus("Cross Currency Not Supported");
			transrepo.save(t);
			return transrepo.findById(tid);
		}
		int ammount = src.getAmt();
		
		if(ammount<amt) {
			
			Transaction t=new Transaction();
			t.setTransactionId(tid);
			t.setAccountFrom(sid);
			t.setAccountTo(rid);
			t.setStatus(false);
			t.setLdt(java.time.LocalDateTime.now());
			t.setOpening(src.getAmt());
			t.setClosing(src.getAmt());
			t.setTotal(0);
			t.setTransStatus("Insufficent Balance ammount and amt is "+ammount +" " + amt );
			transrepo.save(t);
			return transrepo.findById(tid);
			
		}
		
		src.setAmt(ammount-amt);
		
		int temp=dest.getAmt();
		
		dest.setAmt(temp+amt);
		
		Transaction t=new Transaction();
		t.setTransactionId(tid);
		t.setAccountFrom(sid);
		t.setAccountTo(rid);
		t.setStatus(true);
		t.setLdt(java.time.LocalDateTime.now());
		t.setOpening(ammount);
		t.setClosing(ammount+amt);
		t.setTotal(amt);
		t.setTransStatus("Transaction Success!!!");
		transrepo.save(t);
		
		accrepo.save(src);
		
		accrepo.save(dest);
		
		return transrepo.findById(tid);
	}
	
	
}
