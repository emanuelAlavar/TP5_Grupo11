package ar.edu.unju.fi.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


import org.springframework.stereotype.Component;

@Component

public class Alumno {
	@Min(value=8)
	private int dni;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@Email
	private String email;
	@Min(value=10)
	private int telefono;
	
	
	public Alumno(int dni, String nombre, String apellido, String email, int telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public Alumno() {
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}