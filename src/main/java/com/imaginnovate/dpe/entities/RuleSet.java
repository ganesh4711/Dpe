package com.imaginnovate.dpe.entities;

import com.imaginnovate.dpe.common.Enums.RuleStatus;
import com.imaginnovate.dpe.data.domain.RuleAssignmentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rule_set")
@EntityListeners(BaseEntityListener.class)
public class RuleSet extends BaseEntity {

    private String name;
    private String description;
    private RuleStatus status;
    private int activatedUserId;
    private Date activatedAt;
    private int archiveUserId;
    private Date archivedAt;
    private Date applyFrom;
    private Date applyTo;
    List<RuleAssignmentDTO> ruleAssignmentDTOList;

    @Transient
    public List<RuleAssignmentDTO> getRuleAssignmentDTOList() {
        return ruleAssignmentDTOList;
    }
    public void setRuleAssignmentDTOList(List<RuleAssignmentDTO> ruleAssignmentDTOList) {
        this.ruleAssignmentDTOList = ruleAssignmentDTOList;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    public RuleStatus getStatus() {
        return status;
    }

    @Column(name = "activated_userid")
    public int getActivatedUserId() {
        return activatedUserId;
    }

    @Column(name ="activated_at")
    public Date getActivatedAt() {
        return activatedAt;
    }
    @Column(name = "archive_userid")
    public int getArchiveUserId() {
        return archiveUserId;
    }
    @Column(name = "archived_at")
    public Date getArchived_At() {
        return archivedAt;
    }

    @Column(name = "apply_from")
    public Date getApplyFrom() {
        return applyFrom;
    }

    @Column(name = "apply_to")
    public Date getApplyTo() {
        return applyTo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(RuleStatus status) {
        this.status = status;
    }

    public void setActivatedUserId(int activatedUserId) {
        this.activatedUserId = activatedUserId;
    }

    public void setActivatedAt(Date activatedAt) {
        this.activatedAt = activatedAt;
    }

    public void setArchiveUserId(int archiveUserId) {
        this.archiveUserId = archiveUserId;
    }

    public void setArchived_At(Date archivedAt) {
        this.archivedAt = this.archivedAt;
    }

    public void setApplyFrom(Date applyFrom) {
        this.applyFrom = applyFrom;
    }

    public void setApplyTo(Date applyTo) {
        this.applyTo = applyTo;
    }
}
