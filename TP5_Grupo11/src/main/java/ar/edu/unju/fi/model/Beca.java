package ar.edu.unju.fi.model;

import org.springframework.format.annotation.DateTimeFormat;

public class Beca {
	private int codigo;
	//private Curso curso;
	private String curso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaCierre;
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
