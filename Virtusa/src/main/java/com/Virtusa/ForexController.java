package com.Virtusa;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/forex")
public class ForexController {
	
	private static final int max=9999;
	
	private static final int min=1000;

	@Autowired
	AccountRepo accrepo;
	
	@Autowired
	TransactionRepo transrepo;
	
	@PostMapping("/cross/{sid}/{rid}/{amt}")
	public Optional<Transaction> makePayment(@PathVariable("sid") int sid,@PathVariable("rid") int rid,@PathVariable("amt") int amt) {
		
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
		
		String srcCnt=src.getCountry();
		
		String dstCnt=dest.getCountry();
		
		RestTemplate restTemplate=new RestTemplate();
		
		String baseUrl="http://localhost:8541/forex/get/";
		
		Currecncy srcCurr=restTemplate.getForObject(baseUrl+src.getCountry(),Currecncy.class);
		
		Currecncy dstCurr=restTemplate.getForObject(baseUrl+dest.getCountry(),Currecncy.class);
		
			double amtInAcc=src.getAmt()*srcCurr.getFactor();
			
			double req=amt+srcCurr.getForexCost();
			
			int db=(int)amtInAcc;
			
			int reqv=(int)req;
			
			System.out.println(srcCurr.getCountry());
			
			System.out.println(dstCurr.getCountry());
		
			if(db<reqv) {
			
			Transaction t=new Transaction();
			t.setTransactionId(tid);
			t.setAccountFrom(sid);
			t.setAccountTo(rid);
			t.setStatus(false);
			t.setLdt(java.time.LocalDateTime.now());
			t.setOpening(src.getAmt());
			t.setClosing(src.getAmt());
			t.setTotal(0);
			t.setTransStatus("Insufficent Balance!" );
			transrepo.save(t);
			return transrepo.findById(tid);
			
		}
			
		db-=reqv;
		
		int fin=(int)(db/srcCurr.getFactor());
		
		src.setAmt(fin);
		
		accrepo.save(src);
		
		int std=(int)(amt/srcCurr.getFactor());
		
		int a=dest.getAmt();
		
		dest.setAmt(a+std);
		
		accrepo.save(dest);
		
		Transaction t=new Transaction();
		t.setTransactionId(tid);
		t.setAccountFrom(sid);
		t.setAccountTo(rid);
		t.setStatus(true);
		t.setLdt(java.time.LocalDateTime.now());
		t.setOpening(db+reqv);
		t.setClosing(db);
		t.setTotal(amt);
		t.setTransStatus("Transaction Success!!!");
		transrepo.save(t);
		
		return transrepo.findById(tid);
	}
}
