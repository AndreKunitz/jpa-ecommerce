package me.github.andrekunitz.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "order_line_item")
public class OrderLineItem {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "product_price")
	private BigDecimal productPrice;

	private Integer quantity;
}
