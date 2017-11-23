package ucla.si.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Vehiculo implements Serializable, Cloneable{
	
	private Long vehiculo_id;
	private Integer anno;
	private Integer nro_puestos;
	private String serial_carroceria;
	private String serial_motor;
	private Float kilometraje;
	private Usuario usuario;
	private Color color;
	private Uso uso;
	private Modelo modelo;
	
	
	public Vehiculo(){
	
	}


	public Vehiculo(Long vehiculo_id, Integer anno, Integer nro_puestos,
			String serial_carroceria, String serial_motor, Float kilometraje,
			Usuario usuario, Color color, Uso uso, Modelo modelo) {
		super();
		this.vehiculo_id = vehiculo_id;
		this.anno = anno;
		this.nro_puestos = nro_puestos;
		this.serial_carroceria = serial_carroceria;
		this.serial_motor = serial_motor;
		this.kilometraje = kilometraje;
		this.usuario = usuario;
		this.color = color;
		this.uso = uso;
		this.modelo = modelo;
	}


	@Id
	@GeneratedValue
	public Long getVehiculo_id() {
		return vehiculo_id;
	}


	public void setVehiculo_id(Long vehiculo_id) {
		this.vehiculo_id = vehiculo_id;
	}


	public Integer getAnno() {
		return anno;
	}


	public void setAnno(Integer anno) {
		this.anno = anno;
	}


	public Integer getNro_puestos() {
		return nro_puestos;
	}


	public void setNro_puestos(Integer nro_puestos) {
		this.nro_puestos = nro_puestos;
	}


	public String getSerial_carroceria() {
		return serial_carroceria;
	}


	public void setSerial_carroceria(String serial_carroceria) {
		this.serial_carroceria = serial_carroceria;
	}


	public String getSerial_motor() {
		return serial_motor;
	}


	public void setSerial_motor(String serial_motor) {
		this.serial_motor = serial_motor;
	}


	public Float getKilometraje() {
		return kilometraje;
	}


	public void setKilometraje(Float kilometraje) {
		this.kilometraje = kilometraje;
	}

	@ManyToOne
	@JoinColumn(name="usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
  
     
	@ManyToOne
	@JoinColumn(name="color_id")
	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

	@ManyToOne
	@JoinColumn(name="uso_id")
	public Uso getUso() {
		return uso;
	}


	public void setUso(Uso uso) {
		this.uso = uso;
	}


	@ManyToOne
	@JoinColumn(name="modelo_id")
	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	

}
