package br.com.pbna.entidade;

import java.io.Serializable;

public abstract class SuperEntity<PK extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 8839122336732003845L;

	public abstract PK getId();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperEntity<PK> other = (SuperEntity<PK>) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
}
