package com.example.testheroku2.Model;

import java.util.Date;

public class Cleaning {

    private int cleaningId;
    private int weekNumb;
    private Section cleaningSection;
    private Member assignedTo;
    private Member doneBy;
    private Date completionDate;
    private boolean approvedStatus;

    public Cleaning() {
    }

    public Cleaning(int cleaningId, int weekNumb, Section cleaningSection, Member assignedTo,
                    Member doneBy, Date completionDate, boolean approvedStatus) {
        this.cleaningId = cleaningId;
        this.weekNumb = weekNumb;
        this.cleaningSection = cleaningSection;
        this.assignedTo = assignedTo;
        this.doneBy = doneBy;
        this.completionDate = completionDate;
        this.approvedStatus = approvedStatus;
    }

    public int getCleaningId() {
        return cleaningId;
    }

    public void setCleaningId(int cleaningId) {
        this.cleaningId = cleaningId;
    }

    public int getWeekNumb() {
        return weekNumb;
    }

    public void setWeekNumb(int weekNumb) {
        this.weekNumb = weekNumb;
    }

    public Section getCleaningSection() {
        return cleaningSection;
    }

    public void setCleaningSection(Section cleaningSection) {
        this.cleaningSection = cleaningSection;
    }

    public Member getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Member assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Member getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(Member doneBy) {
        this.doneBy = doneBy;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isApprovedStatus() {
        return approvedStatus;
    }

    public void setApprovedStatus(boolean approvedStatus) {
        this.approvedStatus = approvedStatus;
    }
}
