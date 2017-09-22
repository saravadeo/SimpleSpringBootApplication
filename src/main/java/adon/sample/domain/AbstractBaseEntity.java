package adon.sample.domain;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import com.eaio.uuid.UUID;

@MappedSuperclass
@EntityListeners(AbstractBaseEntity.AbstractBaseEntityListener.class)
public abstract class AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 4710568104319098718L;

	@Id
	private String uuid;

	@NotNull
	private ZonedDateTime created;

	@NotNull
	private ZonedDateTime updated;

	public String getUuid() {
		if (uuid == null) {
			uuid = new UUID().toString();
		}
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ZonedDateTime getCreated() {
		return created;
	}

	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}

	public ZonedDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(ZonedDateTime updated) {
		this.updated = updated;
	}

	public static class AbstractBaseEntityListener {

		/**
		 * Set the created and updated fields before every database save.
		 * 
		 * @param abstractEntity
		 *            The entity for which to update the timestamps
		 */
		@PrePersist
		public void onPrePersist(AbstractBaseEntity abstractEntity) {
			abstractEntity.getUuid();
			if (abstractEntity.getCreated() == null) {
				abstractEntity.setCreated(ZonedDateTime.now(ZoneOffset.UTC));
			}
			abstractEntity.setUpdated(ZonedDateTime.now(ZoneOffset.UTC));
		}

		@PreUpdate
		public void onPreUpdate(AbstractBaseEntity abstractEntity) {
			abstractEntity.setUpdated(ZonedDateTime.now(ZoneOffset.UTC));
		}
	}
}
