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
public class Modelo implements Serializable, Cloneable {
	
	
	private Long modelo_id;
	private Integer anno;
	private List<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
	private Marca marca;
	
	
	public Modelo(){
		
	}


	public Modelo(Long modelo_id, Integer anno, List<Vehiculo> vehiculo) {
		super();
		this.modelo_id = modelo_id;
		this.anno = anno;
		this.vehiculo = vehiculo;
	}

    @Id
    @GeneratedValue
	public Long getModelo_id() {
		return modelo_id;
	}


	public void setModelo_id(Long modelo_id) {
		this.modelo_id = modelo_id;
	}


	public Integer getAnno() {
		return anno;
	}


	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	@OneToMany(targetEntity=Vehiculo.class, mappedBy="modelo", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Vehiculo> getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(List<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}

    
	@ManyToOne
	@JoinColumn(name="marca_id")
	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
	
	
	

}
