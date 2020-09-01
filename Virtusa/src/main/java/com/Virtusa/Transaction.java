package com.Virtusa;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {
	@Id
	private Integer TransactionId;
	public Integer getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(Integer transactionId) {
		TransactionId = transactionId;
	}
	public Integer getAccountTo() {
		return AccountTo;
	}
	public void setAccountTo(Integer accountTo) {
		AccountTo = accountTo;
	}
	public String getTransStatus() {
		return TransStatus;
	}
	public void setTransStatus(String transStatus) {
		TransStatus = transStatus;
	}
	public Integer getAccountFrom() {
		return AccountFrom;
	}
	public void setAccountFrom(Integer accountFrom) {
		AccountFrom = accountFrom;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getTotal() {
		return Total;
	}
	public void setTotal(Integer total) {
		Total = total;
	}
	public Integer getOpening() {
		return Opening;
	}
	public void setOpening(Integer opening) {
		Opening = opening;
	}
	public Integer getClosing() {
		return Closing;
	}
	public void setClosing(Integer closing) {
		Closing = closing;
	}
	public LocalDateTime getLdt() {
		return ldt;
	}
	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}
	private Integer AccountTo;
	private String TransStatus;
	private Integer AccountFrom;
	private Boolean status;
	private Integer Total;
	private Integer Opening;
	private Integer Closing;
	private LocalDateTime ldt;
	
		
}
