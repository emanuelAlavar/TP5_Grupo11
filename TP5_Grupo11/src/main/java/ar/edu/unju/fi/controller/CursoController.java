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
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICursoService;

@Controller
@RequestMapping
public class CursoController {
	@Autowired
	ICursoService cursoService;
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);

	@Autowired
	private Curso curso;
	
	@GetMapping("/cursos")
	public String getDocentesPage(Model model) {
		List<Curso> cursos = cursoService.obtenerCursos();
		model.addAttribute("cursos", cursos);
		return "lista_curso";
	}
	
	@GetMapping("/nuevoCurso")
	public String getFormNuevoCursoPage(Model model) {
		model.addAttribute("curso", curso);
		return "nuevo_curso";
	}
	
	@PostMapping("/saveCurso")
	public String guardar(@Valid Curso curso, Model model) {
		cursoService.guardarCurso(curso);
		return "redirect:/cursos";
	}
	
	@GetMapping("/cursoEditar/{codigo}")
	public ModelAndView getEditCursoPage(@PathVariable(value="codigo")int codigo) {
		if(codigo==0) {
			ModelAndView mav = new ModelAndView("redirect:/cursos");
			return mav;
		}
		ModelAndView mav= new ModelAndView("editar_curso");
		Curso curso = cursoService.buscarCurso(codigo);
		mav.addObject("curso",curso);
		return mav;
	}
	
	@PostMapping("/cursoModificar")
	public ModelAndView editarDatosCurso(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error"+curso);
			ModelAndView mav= new ModelAndView("editar_curso");
			mav.addObject("curso",curso);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/cursos");
		cursoService.modificarCurso(curso);
		LOGGER.info("Se ha modificado el curso codigo: "+curso.getCodigo());
		return mav;
	}
	
	@GetMapping("/cursoEliminar/{codigo}")
	public ModelAndView eliminarCurso(@PathVariable("codigo") int codigo) {
		ModelAndView mav=new ModelAndView("redirect:/cursos");
        cursoService.eliminarCurso(codigo);
        return mav;
	}
}