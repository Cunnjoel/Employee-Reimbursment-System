package models;

import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {

    private Integer id;
    private Double amount;
    private Date submitted;
    private Date resolved;
    private String description;
    private Blob receipt;
    private Integer userId;
    private Integer statusId;
    private Integer typeId;

    public Reimbursement() {
    }

    public Reimbursement(Integer id, Integer statusId) {
        this.id = id;
        this.statusId = statusId;
    }

    public Reimbursement(Integer id, Double amount, Date submitted, Date resolved, String description, Blob receipt) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;

    }

    public Reimbursement(Double amount, Integer userId, Integer statusId, Integer typeId) {
        this.amount = amount;
        this.userId = userId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimbursement(Integer id, Double amount, Date submitted, Date resolved, String description, Blob receipt, Integer userId, Integer statusId, Integer typeId) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.userId = userId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getReceipt() {
        return receipt;
    }

    public void setReceipt(Blob receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                '}';
    }

}
