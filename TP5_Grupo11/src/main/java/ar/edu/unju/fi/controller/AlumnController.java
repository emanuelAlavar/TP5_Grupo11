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

import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.service.IAlumnService;
@Controller
@RequestMapping
public class AlumnController {
	@Autowired
	IAlumnService alumnoService;
	
	private static final Log LOGGER = LogFactory.getLog(AlumnController.class);

	@Autowired
	private Alumno alumno;
	
	@RequestMapping("/alumnos")
	public String getAlumnoForm(Model model) {
		List<Alumno> alumnos = alumnoService.obtenerAlumnos();
		model.addAttribute("alumnos", alumnos);
		return "lista_alumno";
	}
	
	@GetMapping("/nuevoAlumno")
	public String agregar(Model model) {
		model.addAttribute("alumno", alumno);
		return "nuevo_alumno";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid Alumno alumno, Model model) {
		alumnoService.guardarAlumno(alumno);
		return "redirect:/alumnos";
	}
	
	
	@GetMapping("/alumnoEditar/{dni}")
	public ModelAndView getEditAlumnoPage(@PathVariable(value="dni") int dni) {
		if(dni == 0) {
			ModelAndView mav= new ModelAndView("redirect:/alumnos");
			return mav;
		}
		ModelAndView mav= new ModelAndView("editar_alumno");
		Alumno alumno= alumnoService.buscarAlumno(dni);
		mav.addObject("alumno", alumno);
		return mav;
	}
	
	@PostMapping("/alumnoModificar")
	public ModelAndView editarDatosAlumno(@Validated @ModelAttribute("alumno") Alumno alumno , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error"+alumno);
			ModelAndView mav= new ModelAndView("editar_alumno");
			mav.addObject("alumno",alumno);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/alumnos");
		alumnoService.modificarAlumno(alumno);
		LOGGER.info("Se ha modificado el alumno ID: "+alumno.getDni());
		return mav;
	}
	
	@GetMapping("/alumnoEliminar/{dni}")
	public ModelAndView eliminarAlumno(@PathVariable("dni") int dni) {
		ModelAndView mav=new ModelAndView("redirect:/alumnos");
        alumnoService.eliminarAlumno(dni);
        return mav;
	}
}