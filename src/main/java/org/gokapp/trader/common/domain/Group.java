package org.gokapp.trader.common.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Specifies the Group
 * @author gokulr
 *
 */
@RedisHash("group")
@AllArgsConstructor
@NoArgsConstructor
public class Group {

	@Id
	@Getter
	@Setter
	private String groupId;
	
	@Getter
	@Setter
	private String groupdName;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((groupdName == null) ? 0 : groupdName.hashCode());
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
		Group other = (Group) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (groupdName == null) {
			if (other.groupdName != null)
				return false;
		} else if (!groupdName.equals(other.groupdName))
			return false;
		return true;
	}
	
	
}
