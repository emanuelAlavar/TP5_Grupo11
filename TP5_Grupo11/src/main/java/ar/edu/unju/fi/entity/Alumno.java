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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "alumnos")
@Component
public class Alumno implements Serializable {

	private static final long serialVersionUID = -5985116137557861020L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "legajo")
	private int legajo;
	@Column(name = "dni") @Min(value=1000000, message="El DNI debe tener minimo 7 cifras o un cifras de 8") @Max(value=99999999, message="El DNI debe tener maxnimo 7 cifras o un maximo de 8")
	private int dni;
	@Column(name = "nombre") @NotEmpty(message="El Nombre no puede estar vacio")
	private String nombre;
	@Column(name = "apellido") @NotEmpty(message="El Apellido no puede estar vacio")
	private String apellido;
	@Column(name = "email") @NotEmpty(message="Ingrese un Email valido") @Email(message="Ingrese un Email valido")
	private String email;
	@Column(name = "telefono") @Size(min=7, max=12, message="El Telefono debe tener como minimo 7 cifras o un maximo de 12")
	private String telefono;
	@Column(name="estado")
	private boolean estado;
	
	//-----ALUMNO A CURSO-----
	@ManyToMany(mappedBy = "alumnos")
	private List<Curso> curso;
	
	
	public Alumno(int dni, String nombre, String apellido, String email, String telefono, boolean estado) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.estado=estado;
	}

	public Alumno() {
	}
	
	

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}