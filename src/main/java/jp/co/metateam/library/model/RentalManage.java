package jp.co.metateam.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * 貸出
 */
@Entity
@Getter
@Setter
@Table(name = "RentalManage")
public class RentalManage {

    /** 貸出ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false)
    private Long rentalId;

    /** 在庫管理番号 */
    @Column(name = "stock_id", nullable = false)
    private String stockId;

    /** 社員番号 */
    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    /** 貸出予定日 */
    @Column(name = "expected_rental_on", nullable = false)
    private Timestamp expectedRentalOn;

     /** 返却予定日 */
    @Column(name = "expected_return_on", nullable = false)
    private Timestamp expectedReturnOn;

    /** キャンセル日時 */
    @Column(name = "canceled_at")
    private Timestamp canceledAt;

    /** 貸出日時 */
    @Column(name = "rentaled_at")
    private Timestamp rentaledAt;

     /** 返却日時 */
    @Column(name = "returned_at")
    private Timestamp returnedAt;

    /** 貸出ステータス */
    @Column(name = "status", nullable = false)
    private String status;

    /** 登録日時 */
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    /** 更新日時 */
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;


    /** Getters */

    public Long getRentalId() {
        return this.rentalId;
    }

    public String getStockId() {
        return this.stockId;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public Timestamp getExpectedRentalOn() {
        return this.expectedRentalOn;
    }

    public Timestamp getExpectedReturnOn() {
        return this.expectedReturnOn;
    }

    public Timestamp getCanceledAt() {
        return this.canceledAt;
    }

    public Timestamp getRentaledAt() {
        return this.rentaledAt;
    }

    public Timestamp getReturnedAt() {
        return this.returnedAt;
    }

    public String getStatus() {
        return this.status;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    /** Setters */

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setExpectedRentalOn(Timestamp expectedRentalOn) {
        this.expectedRentalOn = expectedRentalOn;
    }

    public void setExpectedReturnOn(Timestamp expectedReturnOn) {
        this.expectedReturnOn = expectedReturnOn;
    }

    public void setCanceledAt(Timestamp canceledAt) {
        this.canceledAt = canceledAt;
    }

    public void setRentaledAt(Timestamp rentaledAt) {
        this.rentaledAt = rentaledAt;
    }

    public void setReturnedAt(Timestamp returnedAt) {
        this.returnedAt = returnedAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

}
