package com.learning.pglocator.model;

public class PGAndOwner {
	private long id;
	private long ownerId;
	public long getId() {
		return id;
	}
	public long getOwnerId() {
		return ownerId;
	}

	/*
	 * public void setId(long id) { this.id = id; } public void setOwnerId(long
	 * ownerId) { this.ownerId = ownerId; }
	 */
	public PGAndOwner(long id, long ownerId) {
		super();
		this.id = id;
		this.ownerId = ownerId;
	}

}
