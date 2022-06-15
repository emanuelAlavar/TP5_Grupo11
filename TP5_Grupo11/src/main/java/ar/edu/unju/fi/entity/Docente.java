package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "docentes")
@Component
public class Docente implements Serializable{
	
	private static final long serialVersionUID = -5985116137557861020L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "legajo")
	private int legajo;
	@Column(name = "nombre") @NotEmpty(message="El Nombre no puede estar vacio")
	private String nombre;
	@Column(name = "apellido") @NotEmpty(message="El Apellido no puede estar vacio")
	private String apellido;
	@Column(name = "email") @NotEmpty(message="Ingrese un Email valido") @Email(message="Ingrese un Email valido")
	private String email;
	@Column(name = "telefono") @Size(min=7, max=12, message="El Telefono debe tener como minimo 7 cifras o un maximo de 12")
	private String telefono;
	
	//-----DOCENTE A CURSO-----
	@ManyToMany(mappedBy = "docentes")
	private List<Curso> cursos;
	
	public Docente(int legajo, String nombre, String apellido, String email, String telefono) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public Docente() {
		super();
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Curso> getCursos(){
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}