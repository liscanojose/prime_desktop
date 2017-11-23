package ucla.si.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ucla.si.modelo.Cita;

@Entity
public class Eventualidad implements Serializable , Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long eventualidad_id;
	private Long tipo_eventualidad_id;
	private String descripcion;
	private Date fecha_creacion;
	private Date fecha_modificacion;
	private Cita cita;
	
	public Eventualidad(){}
	
	public Eventualidad(Long eventualidad_id, Long tipo_eventualidad_id,
			 String descripcion, Date fecha_creacion,
			Date fecha_modificacion) {
		super();
		this.eventualidad_id = eventualidad_id;
		this.tipo_eventualidad_id = tipo_eventualidad_id;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
	}
	@Id
	@GeneratedValue
	public Long getEventualidad_id() {
		return eventualidad_id;
	}
	public void setEventualidad_id(Long eventualidad_id) {
		this.eventualidad_id = eventualidad_id;
	}
	public Long getTipo_eventualidad_id() {
		return tipo_eventualidad_id;
	}
	public void setTipo_eventualidad_id(Long tipo_eventualidad_id) {
		this.tipo_eventualidad_id = tipo_eventualidad_id;
	}
	
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	@ManyToOne
	@JoinColumn(name="cita_id")
	public Cita getCita() {
		return cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	
	

}
