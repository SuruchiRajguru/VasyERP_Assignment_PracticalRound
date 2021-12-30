package com.practical.VasyERP.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="tbl_salesitem")
@Entity
public class SalesItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer salesItemId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="salesId",foreignKey=@ForeignKey(name="salesId"))
	private Sales salesId;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productId",foreignKey=@ForeignKey(name="productId"))
	private Product productId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId",foreignKey=@ForeignKey(name="customerId"))
	private Customer customerId;

	private Double price;
	private Integer Quantity;


}
