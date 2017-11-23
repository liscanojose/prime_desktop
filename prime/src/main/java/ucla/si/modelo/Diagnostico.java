package ucla.si.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ucla.si.modelo.*;

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
public class Diagnostico implements Serializable, Cloneable{
	
	private Long diagnostico_id;
	private String descripcion;
	private Cita cita;
	private Presupuesto presupuesto;
	
	public  Diagnostico() {
		// TODO Auto-generated constructor stub
	
		
	}

	public Diagnostico(Long diagnostico_id, String descripcion) {
		super();
		this.diagnostico_id = diagnostico_id;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue
	public Long getDiagnostico_id() {
		return diagnostico_id;
	}

	public void setDiagnostico_id(Long diagnostico_id) {
		this.diagnostico_id = diagnostico_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "cita_id", nullable = true)
	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	@OneToOne(mappedBy = "diagnostico", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
	
	

}
