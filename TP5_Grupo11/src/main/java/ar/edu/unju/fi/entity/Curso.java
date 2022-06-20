package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "cursos")
@Component
public class Curso implements Serializable{

	private static final long serialVersionUID = -837729566367254945L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "codigo")
	private int codigo;
	@Column(name = "titulo") @NotEmpty(message="El Titulo no puede estar vacio")
	private String titulo;
	@Column(name = "categoria") @NotEmpty(message="La Categoria no puede estar vacia")
	private String categoria;
	@Column(name = "inicio")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @FutureOrPresent(message = "La fecha debe ser actual o futura")
	private LocalDate fechaInicio;
	@Column(name = "cierre")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @FutureOrPresent(message = "La fecha debe ser actual o futura")
	private LocalDate fechaFin;
	@Column(name = "Horas") @Min(value=1, message= " La cantidad de horas minimas es 1") @Max(value=1000, message = "La Cantidad no puede pasar las 1000 horas")
	private int horas;
	@Column(name = "modalidad") @NotEmpty(message="La Modalidad no puede estar vacia")
	private String modalidad;
	@Column(name="estado")
	private boolean estado;
	//-----DOCENTE A CURSO-----
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Docente> docentes;
	
	// -----ALUMNO A CURSO-----
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Alumno> alumnos;
	
	//-----BECA A CURSO-----
	@OneToMany(fetch = FetchType.LAZY)
	private List<Beca> becas;
	
	public Curso(int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFin, int horas,
			String modalidad) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horas = horas;
		this.modalidad = modalidad;
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


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
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


	public List<Docente> getDocentes() {
		return docentes;
	}


	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}


	public List<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}


	public List<Beca> getBecas() {
		return becas;
	}


	public void setBecas(List<Beca> becas) {
		this.becas = becas;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
}
