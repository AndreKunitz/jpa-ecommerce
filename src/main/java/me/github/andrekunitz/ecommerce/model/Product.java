package me.github.andrekunitz.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Product {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	private String name;

	private String description;

	private BigDecimal price;
}
