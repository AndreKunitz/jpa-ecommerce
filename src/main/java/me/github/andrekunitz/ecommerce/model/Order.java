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
public class Order {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	private LocalDateTime orderDate;

	private LocalDateTime conclusionDate;

	private Integer invoiceId;

	private BigDecimal total;

	private OrderStatus status;
}
