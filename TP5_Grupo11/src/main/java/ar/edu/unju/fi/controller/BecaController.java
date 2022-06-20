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
import ar.edu.unju.fi.entity.Beca;
import ar.edu.unju.fi.service.IBecaService;

@Controller
@RequestMapping
public class BecaController {
	@Autowired
	IBecaService becaService;
	
	private static final Log LOGGER = LogFactory.getLog(BecaController.class);
	@Autowired
	private Beca beca;
	
	@RequestMapping("/becas")
	public String getBecaForm(Model model) {
		List<Beca> becas = becaService.obtenerBecas();
		model.addAttribute("becas", becas);
		return "lista_beca";
	}
	
	@GetMapping("/nuevaBeca")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", beca);
		return "nuevo_beca";
	}
	
	@PostMapping("/saveBeca")
	public String guardar(@Valid Beca beca, Model model) {
		becaService.guardarBeca(beca);
		return "redirect:/becas";
	}
	
	@GetMapping("/becaEditar/{codigo}")
	public ModelAndView getEditBecaPage(@PathVariable(value="codigo")int codigo) {
		if(codigo==0) {
			ModelAndView mav = new ModelAndView("redirect:/becas");
			return mav;
		}
		ModelAndView mav= new ModelAndView("editar_beca");
		Beca beca = becaService.buscarBeca(codigo);
		mav.addObject("beca",beca);
		return mav;
	}
	@PostMapping("/becaModificar")
	public ModelAndView editarDatosBeca(@Validated @ModelAttribute("beca")Beca beca, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error"+beca);
			ModelAndView mav= new ModelAndView("editar_beca");
			mav.addObject("beca",beca);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/becas");
		becaService.modificarBeca(beca);
		LOGGER.info("Se ha modificado la beca codigo: "+beca.getCodigo());
		return mav;
	}
	
	@GetMapping("/becaEliminar/{codigo}")
	public ModelAndView eliminarBeca(@PathVariable("codigo") int codigo) {
		ModelAndView mav=new ModelAndView("redirect:/becas");
        becaService.eliminarBeca(codigo);
        return mav;
	}
}