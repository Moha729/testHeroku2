package com.example.testheroku2.Model;

public class Section {

    private int sectionId;
    private String sectionName;
    private boolean sectionActiveStatus;

    public Section() {
    }

    public Section(int sectionId, String sectionName, boolean sectionActiveStatus) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.sectionActiveStatus = sectionActiveStatus;
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

    public boolean isSectionActiveStatus() {
        return sectionActiveStatus;
    }

    public void setSectionActiveStatus(boolean sectionActiveStatus) {
        this.sectionActiveStatus = sectionActiveStatus;
    }
}
