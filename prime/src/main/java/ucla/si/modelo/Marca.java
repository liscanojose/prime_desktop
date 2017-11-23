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
public class Marca implements Serializable, Cloneable {
	
	
	private Long marca_id;
	private String descripcion;
	private List<Modelo> modelo = new ArrayList<Modelo>();
	
	
	
	public Marca(){
		
	}



	public Marca(Long marca_id, String descripcion, List<Modelo> modelo) {
		super();
		this.marca_id = marca_id;
		this.descripcion = descripcion;
		this.modelo = modelo;
	}


    @Id
    @GeneratedValue
	public Long getMarca_id() {
		return marca_id;
	}



	public void setMarca_id(Long marca_id) {
		this.marca_id = marca_id;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@OneToMany(targetEntity=Modelo.class, mappedBy="marca", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Modelo> getModelo() {
		return modelo;
	}



	public void setModelo(List<Modelo> modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	
	
	

}
