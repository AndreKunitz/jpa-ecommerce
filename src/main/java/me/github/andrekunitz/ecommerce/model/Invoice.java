package me.github.andrekunitz.ecommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Invoice {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	private Integer orderId;

	private String xml;

	private Date issueDate;
}
