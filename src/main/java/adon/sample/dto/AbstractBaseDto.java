package adon.sample.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

public abstract class AbstractBaseDto implements Serializable {

	private static final long serialVersionUID = 1869261382636192592L;

	protected String uuid;

	protected ZonedDateTime created;

	protected ZonedDateTime updated;

	public String getUuid() {
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

}
