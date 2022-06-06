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
	@GetMapping("/nuevo")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", new Beca());
		return "nuevo_beca";
	}
	
	@PostMapping("/guar")
	public ModelAndView getListaBecasPage(@ModelAttribute("beca")Beca beca) {
		ModelAndView mav = new ModelAndView("lista_beca");
		
		//recupero el arrayList y agrego un objeto alumno a lista
		if(listaBeca.getBecas().add(beca)) {
			LOGGER.info("Se agregó un objeto al arrayList de becas");
		}
		//enviar el arrayList de alumnos a la página lista_alumnos
		mav.addObject("becas", listaBeca.getBecas());
		return mav;
	}
}