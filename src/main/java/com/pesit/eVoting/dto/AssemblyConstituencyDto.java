package com.pesit.eVoting.dto;

import java.io.Serializable;

public class AssemblyConstituencyDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long districtId;
	private String assembly;
	@Override
	public String toString() {
		return "AssemblyConstituencyDto [id=" + id + ", districtId=" + districtId + ", assembly=" + assembly + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assembly == null) ? 0 : assembly.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (districtId ^ (districtId >>> 32));
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
		AssemblyConstituencyDto other = (AssemblyConstituencyDto) obj;
		if (assembly == null) {
			if (other.assembly != null)
				return false;
		} else if (!assembly.equals(other.assembly))
			return false;
		if (id != other.id)
			return false;
		if (districtId != other.districtId)
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getdistrictId() {
		return districtId;
	}
	public void setdistrictId(long districtId) {
		this.districtId = districtId;
	}
	public String getAssembly() {
		return assembly;
	}
	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

}
