package dxc.assessment.app.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class BaseModelDTO {
    protected boolean deleted;

    protected String createdBy;

    protected LocalDateTime createdTime;

    protected String lastUpdatedBy;

    protected LocalDateTime lastUpdatedTime;

    public BaseModelDTO(boolean deleted, String createdBy, LocalDateTime createdTime, String lastUpdatedBy, LocalDateTime lastUpdatedTime) {
        this.deleted = deleted;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
