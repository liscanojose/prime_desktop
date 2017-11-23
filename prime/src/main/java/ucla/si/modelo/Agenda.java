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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Agenda implements Serializable, Cloneable {
	
	private Long agenda_id;
	private Date fecha;
	private List<Cita> cita = new ArrayList<Cita>();
	
	
	public Agenda(){
		
	}


	public Agenda(Long agenda_id, Date fecha) {
		super();
		this.agenda_id = agenda_id;
		this.fecha = fecha;
	}

    @Id
    @GeneratedValue
	public Long getAgenda_id() {
		return agenda_id;
	}


	public void setAgenda_id(Long agenda_id) {
		this.agenda_id = agenda_id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@OneToMany(targetEntity=Cita.class, mappedBy="agenda", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Cita> getCita() {
		return cita;
	}


	public void setCita(List<Cita> cita) {
		this.cita = cita;
	}
	
	

}
