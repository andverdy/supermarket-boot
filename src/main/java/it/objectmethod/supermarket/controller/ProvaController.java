package it.objectmethod.supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProvaController {
	@RequestMapping("/hello")
	public String getPage() {
		System.out.println("sono nel controller");
		return "home";
	}

}
