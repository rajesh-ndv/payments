package com.ForexService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forex")
public class ForexController {

	@Autowired
	ForexRepository forexRepo;
	
	@GetMapping("/get/{cid}")
	public Optional<Forex> getDetails(@PathVariable("cid") final String cid) {
		
		return forexRepo.findById(cid);
	}
}
