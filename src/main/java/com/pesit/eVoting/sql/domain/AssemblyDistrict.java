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
@Table(name="assembly_district")
public class AssemblyDistrict implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="state_id")
	private long stateId;

	@Column(name="district_name")
	private String districtName;

	@Override
	public String toString() {
		return "AssemblyDistrict [id=" + id + ", stateId=" + stateId + ", districtName=" + districtName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((districtName == null) ? 0 : districtName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (stateId ^ (stateId >>> 32));
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
		AssemblyDistrict other = (AssemblyDistrict) obj;
		if (districtName == null) {
			if (other.districtName != null)
				return false;
		} else if (!districtName.equals(other.districtName))
			return false;
		if (id != other.id)
			return false;
		if (stateId != other.stateId)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	
	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	
	
}
