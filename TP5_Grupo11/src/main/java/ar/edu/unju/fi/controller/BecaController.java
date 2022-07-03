package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Beca;
import ar.edu.unju.fi.service.IBecaService;
import ar.edu.unju.fi.service.ICursoService;

@Controller
@RequestMapping("/beca")
public class BecaController {
	
	@Autowired
	private IBecaService becaSer;
	
	@Autowired
	private ICursoService cursoSer;
	
	private static final Log LOGGER = LogFactory.getLog(BecaController.class);
	
	@GetMapping("/becas")
	public ModelAndView getDocentesPage(Model model) {
		ModelAndView mav = new ModelAndView("lista_beca");
		mav.addObject("becas", becaSer.getBecas());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", becaSer.getBeca());
		model.addAttribute("cursos", cursoSer.getCursos());
		return "nuevo_beca";
	}
	
	@PostMapping("/becas")
	public ModelAndView getListaBecasPage(@Validated @ModelAttribute("beca")Beca beca, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca", beca);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:becas");
		if(becaSer.findByCodigo(beca.getCodigo()) != null) {
			LOGGER.info("Ya existe un alumno con el DNI: "+beca.getCodigo()+" registrado");
			return mav;
		}
		becaSer.saveBeca(beca);
		return mav;
	}
}