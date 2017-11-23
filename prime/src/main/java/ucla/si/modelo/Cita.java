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
public class Cita implements Serializable, Cloneable {
	
	private Long cita_id;
	private String descripcion;
	private Date fecha;
	private Agenda agenda;
	private Usuario usuario;
	private Diagnostico diagnostico;
	
	private List<Eventualidad> eventualidades = new ArrayList<Eventualidad>();
	
	
	public Cita(){
		
	}


	public Cita(Long cita_id, String descripcion, Date fecha) {
		super();
		this.cita_id = cita_id;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}


	@Id
	@GeneratedValue
	public Long getCita_id() {
		return cita_id;
	}


	public void setCita_id(Long cita_id) {
		this.cita_id = cita_id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@ManyToOne
	@JoinColumn(name="agenda_id")
	public Agenda getAgenda() {
		return agenda;
	}


	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@OneToOne(mappedBy = "cita", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	@OneToMany(targetEntity=Eventualidad.class, mappedBy="cita", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Eventualidad> getEventualidades() {
		return eventualidades;
	}


	public void setEventualidades(List<Eventualidad> eventualidades) {
		this.eventualidades = eventualidades;
	}
	
	
	
	
	
	
	
	
	
	

}
