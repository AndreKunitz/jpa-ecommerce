package me.github.andrekunitz.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class OrderLineItem {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	private Integer orderId;

	private Integer productId;

	private BigDecimal productPrice;

	private Integer quantity;
}
