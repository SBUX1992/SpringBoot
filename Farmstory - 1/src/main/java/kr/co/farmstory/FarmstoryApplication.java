package kr.co.farmstory;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class FarmstoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(FarmstoryApplication.class, args);
	}
	
	@GetMapping(value = {"", "index"})
	public String index(Principal principal) {
		
		if(principal != null) {
			// 로그인 했을 경우
			return "redirect:/list";	
		}else {
			// 로그인 안했을 경우
			return "redirect:/user/login";	
		}
		
	}	
}
