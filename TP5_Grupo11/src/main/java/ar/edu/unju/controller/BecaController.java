package ar.edu.unju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class BecaController {

	@GetMapping("/beca")
	public String getBecaPage() {
		return "Beca";
	}
}
