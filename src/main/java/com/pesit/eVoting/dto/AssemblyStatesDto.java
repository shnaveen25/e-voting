package com.pesit.eVoting.dto;

import java.io.Serializable;

public class AssemblyStatesDto implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private long id;
		private String stateName;
		
		@Override
		public String toString() {
			return "AssemblyStatesDto [id=" + id + ", stateName=" + stateName + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
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
			AssemblyStatesDto other = (AssemblyStatesDto) obj;
			if (id != other.id)
				return false;
			if (stateName == null) {
				if (other.stateName != null)
					return false;
			} else if (!stateName.equals(other.stateName))
				return false;
			return true;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getStateName() {
			return stateName;
		}

		public void setStateName(String stateName) {
			this.stateName = stateName;
		}
		
		
}
