package mx.com.banamex.tdc.modelo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Transactional
@Entity
@Table(name = "TDC_CROSSELL_USER")
public class CrosselUserEntity implements Serializable {
	
	private static final long serialVersionUID = -5147847666716210491L;

	@Id
	@Column(name = "crossell_user_soeid")
	private String crossellUserSoeid;
	
	@Column(name = "crossell_user_nombre")
	private String crossellUserNombre;
	
	@Column(name = "crossell_user_pwd")
	private String crossellUserPwd;
	
	@Column(name = "crossel_user_estatus")
	private int crosselUserEstatus;

	@Column(name = "TDC_CROSSELL_USER_PERFIL")
	private int tdcCrossellUserPerfil;

	
	public String getCrossellUserSoeid() {
		return crossellUserSoeid;
	}

	public void setCrossellUserSoeid(String crossellUserSoeid) {
		this.crossellUserSoeid = crossellUserSoeid;
	}

	public int getTdcCrossellUserPerfil() {
		return tdcCrossellUserPerfil;
	}

	public void setTdcCrossellUserPerfil(int tdcCrossellUserPerfil) {
		this.tdcCrossellUserPerfil = tdcCrossellUserPerfil;
	}

	public String getCrossellUserNombre() {
		return crossellUserNombre;
	}

	public void setCrossellUserNombre(String crossellUserNombre) {
		this.crossellUserNombre = crossellUserNombre;
	}

	public String getCrossellUserPwd() {
		return crossellUserPwd;
	}

	public void setCrossellUserPwd(String crossellUserPwd) {
		this.crossellUserPwd = crossellUserPwd;
	}

	public int getCrosselUserEstatus() {
		return crosselUserEstatus;
	}

	public void setCrosselUserEstatus(int crosselUserEstatus) {
		this.crosselUserEstatus = crosselUserEstatus;
	}

	@Override
	public String toString() {
		return "CrosselUserEntity [crossellUserSoeid=" + crossellUserSoeid + ", crossellUserNombre="
				+ crossellUserNombre + ", crossellUserPwd=" + crossellUserPwd + ", crosselUserEstatus="
				+ crosselUserEstatus + ", tdcCrossellUserPerfil=" + tdcCrossellUserPerfil + "]";
	}
	
	

}
