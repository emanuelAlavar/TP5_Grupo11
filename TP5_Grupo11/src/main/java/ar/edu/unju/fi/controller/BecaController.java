package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Beca;
import ar.edu.unju.fi.util.ListaBeca;

@Controller
@RequestMapping("/beca")
public class BecaController {
	
	private static final Log LOGGER = LogFactory.getLog(BecaController.class);
	// creo un objeto de la clase ListaAlumno, donde está el arrayList
	ListaBeca listaBeca = new ListaBeca();
	
	@GetMapping("/becas")
	public ModelAndView getDocentesPage(Model model) {
		ModelAndView mav = new ModelAndView("lista_beca");
		mav.addObject("becas", listaBeca.getBecas());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", new Beca());
		return "nuevo_beca";
	}
	
	@PostMapping("/becas")
	public ModelAndView getListaBecasPage(@ModelAttribute("beca")Beca beca) {
		ModelAndView mav = new ModelAndView("lista_beca");
		
		if(listaBeca.getBecas().add(beca)) {
			LOGGER.info("Se agregó una nueva beca al arrayList de becas");
		}
		mav.addObject("becas", listaBeca.getBecas());
		return mav;
	}
}