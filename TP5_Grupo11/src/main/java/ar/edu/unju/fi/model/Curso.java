package ar.edu.unju.fi.model;


public class Curso {
	private int codigo;
	private String titulo;
	private String categoria;
	private String fechaInicio;
	private String fechaFin;
	private int horas;
	private String modalidad;
	private Docente docente;
	
	
	public Curso(int codigo, String titulo, String categoria, String fechaInicio, String fechaFin, int horas,
			String modalidad, Docente docente) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horas = horas;
		this.modalidad = modalidad;
		this.docente = docente;
	}


	public Curso() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}


	public Docente getDocente() {
		return docente;
	}


	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
	
}
