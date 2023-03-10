package it.epicode.be.epicenergyservices.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="Invoices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="invoice_number")
	private int id;
	
	private int year;
	private LocalDate date;
	private double total;
	@ManyToOne
	@JsonBackReference
	private Customer customer;
	@Enumerated(EnumType.STRING)
	private InvoiceState state;
	
	
}
