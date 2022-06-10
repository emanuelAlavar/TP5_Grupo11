package ar.edu.unju.fi.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component

public class Beca {
	@Min(value=15)
	private int codigo;
	@NotBlank
	//private Curso curso;
	private String curso;
	@NotBlank
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaInicio;
	@NotBlank
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaCierre;
	@NotBlank
	private String estado;
	//private boolean estado;
	
	
	
	public Beca(int codigo, String curso, String fechaInicio, String fechaCierre, String estado) {
		this.codigo = codigo;
		this.curso = curso;
		this.fechaInicio = fechaInicio;
		this.fechaCierre = fechaCierre;
		this.estado = estado;
	}
	public Beca() {
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
