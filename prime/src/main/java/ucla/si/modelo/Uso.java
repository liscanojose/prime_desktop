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
public class Uso implements Serializable, Cloneable {
	
	
	private Long uso_id;
	private String descripcion;
	private List<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
	
	public Uso(){
		
		
	}

	public Uso(Long uso_id, String descripcion, List<Vehiculo> vehiculo) {
		super();
		this.uso_id = uso_id;
		this.descripcion = descripcion;
		this.vehiculo = vehiculo;
	}
 
	@Id
	@GeneratedValue
	public Long getUso_id() {
		return uso_id;
	}

	public void setUso_id(Long uso_id) {
		this.uso_id = uso_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(targetEntity=Vehiculo.class, mappedBy="uso", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Vehiculo> getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(List<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
	
	
	
	

}
