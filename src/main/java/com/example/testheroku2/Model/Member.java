package com.example.testheroku2.Model;

public class Member {

    private int memberId;
    private String memberName;
    private boolean memberActiveStatus;

    public Member(String memberName, int memberId, boolean memberActiveStatus) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberActiveStatus = memberActiveStatus;
    }

    public Member() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public boolean isMemberActiveStatus() {
        return memberActiveStatus;
    }

    public void setMemberActiveStatus(boolean memberActiveStatus) {
        this.memberActiveStatus = memberActiveStatus;
    }
}
