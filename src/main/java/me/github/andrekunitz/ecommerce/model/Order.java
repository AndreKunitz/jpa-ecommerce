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
@Table(name = "order")
public class Order {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	@Column(name = "order_date")
	private LocalDateTime orderDate;

	@Column(name = "conclusion_date")
	private LocalDateTime conclusionDate;

	@Column(name = "invoince_id")
	private Integer invoiceId;

	private BigDecimal total;

	private OrderStatus status;
}
