package ar.edu.unju.fi.controller;
import java.util.List;

import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.service.IDocenteService;

@Controller
@RequestMapping
public class DocenteController {
	@Autowired
	private IDocenteService docenteService;
	
	@Autowired
	private Docente docente;
	
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	// creo un objeto de la clase ListaDocente, donde estÃ¡ el arrayList
	//ListaDocente listaDocentes = new ListaDocente();
		
	@RequestMapping("/docentes")
	public String getDocentesTable(Model model) {
		List<Docente> docentes = docenteService.obtenerDocentes();
		model.addAttribute("docentes",docentes);
		return "lista_docentes";
	}
	
	@GetMapping("/nuevoDocente")
	public String agregarDocente(Model model) {
		model.addAttribute("docente", docente);
		return "nuevo_docente";
	}
	
	@PostMapping("/saveDocente")
	public String guardarDocente(@Valid Docente docente, Model model) {
		docenteService.guardarDocente(docente);
		return "redirect:/docentes";
	}
	
	@GetMapping("/editarDocente/{legajo}")
	public ModelAndView getEditarDocentePage(@PathVariable(value="legajo") int legajo) {
		if(legajo == 0) {
			ModelAndView mav= new ModelAndView("redirect:/docentes");
			return mav;
		}
		ModelAndView mav= new ModelAndView("editar_docente");
		Docente docente= docenteService.buscarDocente(legajo);
		mav.addObject("docente", docente);
		return mav;
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("docente") Docente docente , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error"+docente);
			ModelAndView mav= new ModelAndView("editar_docente");
			mav.addObject("docente",docente);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/docentes");
		docenteService.modificarDocente(docente);
		LOGGER.info("Se ha modificado el docente legajo: "+docente.getLegajo());
		return mav;
	}
	
	
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView eliminarDocente(@PathVariable("legajo") int legajo) {
		ModelAndView mav = new ModelAndView("redirect:/docentes");
		if(legajo!= 0) {
			docenteService.eliminarDocente(legajo);
			LOGGER.info("Se elimino el docente legajo: "+legajo);
		}
		return mav;
	}	
}