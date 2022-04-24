package me.github.andrekunitz.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Category {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	private String name;

	private Integer parentCategoryId;
}
