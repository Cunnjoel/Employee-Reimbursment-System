package models;

public class Status {
    private Integer id;
    private String status;
    private Reimbursement reimbursementId;

    public Status() {
    }

    public Status(Integer id, String status, Reimbursement reimbursementId) {
        this.id = id;
        this.status = status;
        this.reimbursementId = reimbursementId;
    }

    public Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Reimbursement getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Reimbursement reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
