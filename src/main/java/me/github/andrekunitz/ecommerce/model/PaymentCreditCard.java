package me.github.andrekunitz.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "payment_credit_card")
public class PaymentCreditCard {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	@Column(name = "order_id")
	private Integer orderId;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	@Column(name = "card_number")
	private String cardNumber;
}
