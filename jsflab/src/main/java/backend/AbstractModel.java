package backend;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;

public class AbstractModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7453978202734909608L;
	@Column(name = "uuid", nullable = false, length = 36, unique = true)
	private UUID uuid;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
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
		AbstractModel other = (AbstractModel) obj;
		if (getUuid() == null) {
			if (other.getUuid() != null)
				return false;
		} else if (!getUuid().equals(other.getUuid()))
			return false;
		return true;
	}
	public UUID getUuid(){
		if(uuid == null){
			uuid = UUID.randomUUID();
		}
		return uuid;
	}
	
	
}
