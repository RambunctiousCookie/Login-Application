package user.login.app.model;

import user.login.app.DTO.BaseModelDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseModel {

    protected boolean deleted;

    protected String createdBy;

    protected LocalDateTime createdTime;

    protected String lastUpdatedBy;

    protected LocalDateTime lastUpdatedTime;

    public BaseModel() {}

    public BaseModel(boolean deleted, String createdBy, LocalDateTime createdTime, String lastUpdatedBy, LocalDateTime lastUpdatedTime) {
        this.deleted = deleted;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public BaseModel(BaseModelDTO baseModelDTO){
        this.deleted = baseModelDTO.isDeleted();
        this.createdBy = baseModelDTO.getCreatedBy();
        this.createdTime = baseModelDTO.getCreatedTime();
        this.lastUpdatedBy = baseModelDTO.getLastUpdatedBy();
        this.lastUpdatedTime = baseModelDTO.getLastUpdatedTime();
    }

    public boolean isActive(){
        return !this.deleted;
    }

    @Override
    public String toString() {
        return "Base Attributes(isDeleted=" +
                this.isDeleted() +
                ", createdBy=" +
                this.getCreatedBy() +
                ", createdTime=" +
                this.getCreatedTime() +
                ", lastUpdatedBy=" +
                this.getLastUpdatedBy() +
                ", lastUpdatedTime=" +
                this.getLastUpdatedTime() + ")";
    }
}