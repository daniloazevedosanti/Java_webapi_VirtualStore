package com.store.entities;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Requisição de pedido")
public class RequestOrder {
	
	private Long clientId;
	private Long productId;
	private Integer quantity;
	
	public RequestOrder() {
		
	}


	public Long getClientId() {
		return clientId;
	}


	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
