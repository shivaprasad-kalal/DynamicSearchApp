package com.shiva.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "INSURANCE_PLANS")
@Data
public class Insurance {
	@Id
	@Column(name = "PLAN_ID", length = 10)
	private Integer planId;
	@Column(name = "PLAN_NAME", length = 20)
	private String planName;
	@Column(name = "PLAN_STATUS", length = 20)
	private String planStatus;
	@Column(name = "PLAN_START_DATE")
	private Date startDate;
	@Column(name = "PLAN_END_DATE")
	private Date endDate;
	@Column(name = "HOLDER_NAME", length = 20)
	private String holderName;
	@Column(name = "HOLDER_SSN", length = 9)
	private Integer ssn;
}
