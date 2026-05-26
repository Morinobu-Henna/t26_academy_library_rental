package jp.co.metateam.library.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 貸出DTO
 */
@Getter
@Setter
public class RentalManageDto {

    @NotEmpty(message = "社員番号は必須です")
    @Size(max = 50)
    private String employee_id;

    @NotNull(message = "貸出予定日は必須です")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expectedRentalOn;

    @NotNull(message = "返却予定日は必須です")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expectedReturnOn;
    
    @NotEmpty(message = "在庫管理番号は必須です")
    @Size(max = 20)
    private String stockId;

    @NotNull(message = "貸出ステータスは必須です") 
    @Min(value = 0, message = "貸出ステータスは「貸出待ち」または「貸出中」を選択してください")
    @Max(value = 1, message = "貸出ステータスは「貸出待ち」または「貸出中」を選択してください")
    private Integer status;

    private Timestamp expectedRentalON;
    private Timestamp expectedRetunON;

    public void validateDate() {
        if (expectedRentalON.after(expectedRetunON)) {
            throw new IllegalArgumentException(
                "貸出予定日は返却予定日以前である必要があります。"
            );
        }
    }

     /** Getters */
 
    public String getEmployeeId() {
        return employee_id;
    }
 
    public LocalDate getExpectedRentalOn() {
        return expectedRentalOn;
    }
 
    public LocalDate getExpectedReturnOn() {
        return expectedReturnOn;
    }
 
    public String getStockId() {
        return stockId;
    }
 
    public Integer getStatus() {
        return status;
    }
 
    /** Setters */
 
    public void setEmployeeId(String employee_id) {
        this.employee_id = employee_id;
    }
 
    public void setExpectedRentalOn(LocalDate expectedRentalOn) {
        this.expectedRentalOn = expectedRentalOn;
    }
 
    public void setExpectedReturnOn(LocalDate expectedReturnOn) {
        this.expectedReturnOn = expectedReturnOn;
    }
 
    public void setStockId(String stockId) {
        this.stockId = stockId;
    }
 
    public void setStatus(Integer status) {
        this.status = status;
    }

}
