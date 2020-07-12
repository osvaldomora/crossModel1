package mx.com.banamex.tdc.modelo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Table(name = "TDC_DOM_BNMX")
@Entity
@Transactional
public class TdcDomBnmx implements Serializable{

	private static final long serialVersionUID = -8611704535290687121L;

	@Id
	@Column(name = "DOM_ID")
	private int domId;
	
	@Column(name = "DOM_NOMBRE_URL")
	private String domNombreUrl;
	
	@Column(name = "DOM_ESTATUS")
	private int domEstatus;

	public int getDomId() {
		return domId;
	}

	public void setDomId(int domId) {
		this.domId = domId;
	}

	public String getDomNombreUrl() {
		return domNombreUrl;
	}

	public void setDomNombreUrl(String domNombreUrl) {
		this.domNombreUrl = domNombreUrl;
	}

	public int getDomEstatus() {
		return domEstatus;
	}

	public void setDomEstatus(int domEstatus) {
		this.domEstatus = domEstatus;
	}

}
