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
public class Color implements Serializable, Cloneable {
	
	private Long color_id;
	private String descripcion;
	private List<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
	
	public Color(){
		
	}
	
	
	
	public Color(Long color_id, String descripcion, List<Vehiculo> vehiculo) {
		super();
		this.color_id = color_id;
		this.descripcion = descripcion;
		this.vehiculo = vehiculo;
	}


    @Id
    @GeneratedValue
	public Long getColor_id() {
		return color_id;
	}



	public void setColor_id(Long color_id) {
		this.color_id = color_id;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@OneToMany(targetEntity=Vehiculo.class, mappedBy="color", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Vehiculo> getVehiculo() {
		return vehiculo;
	}



	public void setVehiculo(List<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
	
	
	
	
	

}
