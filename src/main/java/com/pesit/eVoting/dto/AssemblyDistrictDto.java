package com.pesit.eVoting.dto;

import java.io.Serializable;

public class AssemblyDistrictDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long stateId;
	
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	private String districtName;
	@Override
	public String toString() {
		return "AssemblyDistrictDto [id=" + id + ", stateId=" + stateId + ", districtName=" + districtName + "]";
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
		AssemblyDistrictDto other = (AssemblyDistrictDto) obj;
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
	
	
	
}
