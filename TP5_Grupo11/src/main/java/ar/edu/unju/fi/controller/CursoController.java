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

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.IBecaService;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.service.IDocenteService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private ICursoService cursoSer;
	
	@Autowired
	private IDocenteService docenteSer;
	
	@Autowired
	private IBecaService becaSer;
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);

	
	@GetMapping("/cursos")
	public ModelAndView getDocentesPage(Model model) {
		ModelAndView mav = new ModelAndView("lista_curso");
		mav.addObject("cursos", cursoSer.getCursos());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public String getFormNuevoCursoPage(Model model) {
		model.addAttribute("curso", cursoSer.getCurso());
		model.addAttribute("docentes", docenteSer.getDocentes());
		model.addAttribute("beca", becaSer.getBecas());
		return "nuevo_curso";
	}
	
	@PostMapping("/cursos")
	public ModelAndView getListaCursoPage(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso", curso);
			mav.addObject("docentes", docenteSer.getDocentes());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:cursos");
		if(cursoSer.findByCodigo(curso.getCodigo()) != null) {
			LOGGER.info("Ya existe un curso con el Codigo: "+curso.getCodigo()+" registrado");
			return mav;
		}
		cursoSer.saveCurso(curso);
		return mav;
	}
}