package com.presentationit.api.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public abstract class AbstractDto implements Serializable {

	@ApiModelProperty(value = "L'identiant technique", dataType = "Long")
	private Long id;

	@ApiModelProperty(value = "Date de création", dataType = "DateTime")
	private Date createdAt;

	@ApiModelProperty(value = "Date de la dernière modification", dataType = "DateTime")
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
