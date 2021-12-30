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
@Table(name="tbl_sales")
@Entity
public class Sales {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer salesId;
	
	
	private Integer salesNo;
	private Date salesDate;
	private Double total;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId",foreignKey=@ForeignKey(name="customerId"))
	private Customer customerId;

}
