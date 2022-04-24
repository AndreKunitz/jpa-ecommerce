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
@Table(name = "payment_bank_slip")
public class PaymentBankSlip {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	@Column(name = "order_id")
	private Integer orderId;

	private PaymentStatus status;

	@Column(name = "bar_code")
	private String barCode;
}
