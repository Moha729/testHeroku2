package com.example.testheroku2.Model.cleaning;

public class CleaningArea {

    private int sectionId;
    private String sectionName;
    private String assignedTo;
    private String doneBy;
    private String completionDate;
    private boolean approvedStatus;

    public CleaningArea() {
    }

    public CleaningArea(int sectionId, String sectionName, String assignedTo, String doneBy,
                        String completionDate, boolean approvedStatus) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.assignedTo = assignedTo;
        this.doneBy = doneBy;
        this.completionDate = completionDate;
        this.approvedStatus = approvedStatus;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isApprovedStatus() {
        return approvedStatus;
    }

    public void setApprovedStatus(boolean approvedStatus) {
        this.approvedStatus = approvedStatus;
    }
}
