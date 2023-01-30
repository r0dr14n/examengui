package clases;

import java.util.Objects;

public class Autocar {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int kilometros;
	private int num_plazas;
	
	// Constructor
	
	public Autocar() {
		this.matricula="";
		this.marca="";
		this.modelo="";
		this.kilometros=0;
		this.num_plazas=0;
	}
	
	// Constructor con parametros
	
	public Autocar(String matricula, String marca, String modelo, int kilometros, int num_plazas) {
		this.matricula=matricula;
		this.marca=marca;
		this.modelo=modelo;
		this.kilometros=kilometros;
		this.num_plazas=num_plazas;
	}
	
	// Constructor de copia
	
	public Autocar(Autocar a) {
		this.matricula=a.matricula;
		this.marca=a.marca;
		this.modelo=a.modelo;
		this.kilometros=a.kilometros;
		this.num_plazas=a.num_plazas;
	}

	// Getters y Setters
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public int getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(kilometros, marca, matricula, modelo, num_plazas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autocar other = (Autocar) obj;
		return kilometros == other.kilometros && Objects.equals(marca, other.marca)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(modelo, other.modelo)
				&& num_plazas == other.num_plazas;
	}

	@Override
	public String toString() {
		return "Autocar [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", kilometros="
				+ kilometros + ", num_plazas=" + num_plazas + "]";
	}
	
	
	
	
	
	
	
	
}
