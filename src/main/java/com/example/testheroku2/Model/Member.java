package com.example.testheroku2.Model;

public class Member {

    private int memberId;
    private String memberName;

    public Member(String memberName, int memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
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


}
