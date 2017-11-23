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
public class Presupuesto implements Serializable, Cloneable {

	
	private Long presupuesto_id;
	private Diagnostico diagnostico;
	private String concepto;
	private int cantidad;
	private float costo;
	private float monto_total;
	
	public Presupuesto(){
		
	}

	public Presupuesto(Long presupuesto_id, String concepto, int cantidad,
			float costo, float monto_total) {
		super();
		this.presupuesto_id = presupuesto_id;
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.costo = costo;
		this.monto_total = monto_total;
	}

	@Id
	@GeneratedValue
	public Long getPresupuesto_id() {
		return presupuesto_id;
	}

	public void setPresupuesto_id(Long presupuesto_id) {
		this.presupuesto_id = presupuesto_id;
	}


	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "diagnostico_id", nullable = true)
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public float getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(float monto_total) {
		this.monto_total = monto_total;
	}
	
	
	
}
