package mx.com.banamex.tdc.modelo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Transactional
@Entity
@Table(name = "TDC_PROCS")
public class TdcProcesosEntity implements Serializable{
	
	private static final long serialVersionUID = 6160025322584700710L;

	@Id
	@Column(name = "TDC_PROCS_ID")
	private int tdcProcsId;
	
	@Column(name = "TDC_PROCS_NOMBRE")
	private String tdcProcsNombre;
	
	@Column(name = "TDC_PROCS_FECEXE")
	private Timestamp tdcProcsFecexe;
	
	@Column(name = "TDC_PROCS_STATUS")
	private String tdcProcsStatus;
	
	@Column(name = "TDC_PROCS_DESCRIPCION_ERR")
	private String tdcProcsDescripcionErr;
	
	@Column(name = "TDC_PROCS_INSERT_REG")
	private int tdcProcsInsertReg;

	public int getTdcProcsInsertReg() {
		return tdcProcsInsertReg;
	}

	public void setTdcProcsInsertReg(int tdcProcsInsertReg) {
		this.tdcProcsInsertReg = tdcProcsInsertReg;
	}

	public String getTdcProcsDescripcionErr() {
		return tdcProcsDescripcionErr;
	}

	public void setTdcProcsDescripcionErr(String tdcProcsDescripcionErr) {
		this.tdcProcsDescripcionErr = tdcProcsDescripcionErr;
	}

	public int getTdcProcsId() {
		return tdcProcsId;
	}

	public void setTdcProcsId(int tdcProcsId) {
		this.tdcProcsId = tdcProcsId;
	}

	public String getTdcProcsNombre() {
		return tdcProcsNombre;
	}

	public void setTdcProcsNombre(String tdcProcsNombre) {
		this.tdcProcsNombre = tdcProcsNombre;
	}

	public Timestamp getTdcProcsFecexe() {
		return tdcProcsFecexe;
	}

	public void setTdcProcsFecexe(Timestamp tdcProcsFecexe) {
		this.tdcProcsFecexe = tdcProcsFecexe;
	}

	public String getTdcProcsStatus() {
		return tdcProcsStatus;
	}

	public void setTdcProcsStatus(String tdcProcsStatus) {
		this.tdcProcsStatus = tdcProcsStatus;
	}

}
