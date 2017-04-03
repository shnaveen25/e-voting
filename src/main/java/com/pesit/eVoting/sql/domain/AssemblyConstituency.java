package com.pesit.eVoting.sql.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author 
 *
 */

@Entity
@Table(name="assembly_constituency")
public class AssemblyConstituency implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="district_id")
	private long districtId;
	
	@Column(name="assembly")
	private String assembly;

	@Override
	public String toString() {
		return "assembly_constituency [id=" + id + ", districtId=" + districtId + ", assembly=" + assembly + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assembly == null) ? 0 : assembly.hashCode());
		result = prime * result + (int) (districtId ^ (districtId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssemblyConstituency other = (AssemblyConstituency) obj;
		if (assembly == null) {
			if (other.assembly != null)
				return false;
		} else if (!assembly.equals(other.assembly))
			return false;
		if (districtId != other.districtId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}
	
	

}
