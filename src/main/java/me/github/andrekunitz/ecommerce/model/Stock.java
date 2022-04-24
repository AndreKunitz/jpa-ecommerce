package me.github.andrekunitz.ecommerce.model;

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
@Table(name = "stock")
public class Stock {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	@Column(name = "product_id")
	private Integer productId;

	private Integer quantity;
}
