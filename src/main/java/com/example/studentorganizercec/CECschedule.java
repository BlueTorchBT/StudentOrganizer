package com.example.studentorganizercec;

public class CECschedule {

    private int cycle;
    private String p1room;
    private String p1subject;
    private String p2room;
    private String p2subject;
    private String p3room;
    private String p3subject;
    private String p4room;
    private String p4subject;

    public CECschedule(int c, String p1r, String p1s, String p2r, String p2s, String p3r, String p3s, String p4r, String p4s) {
        setCycle(c);
        setp1room(p1r);
        setp1subject(p1s);
        setp2room(p2r);
        setp2subject(p4s);
        setp3room(p3r);
        setp3subject(p4s);
        setp4room(p4r);
        setp4subject(p4s);
    }

    int getCycle() {
        return cycle;
    }

    String getp1room() {
        return p1room;
    }

    String getp1subject() {
        return p1subject;
    }

    String getp2room() {
        return p1room;
    }

    String getp2subject() {
        return p1subject;
    }

    String getp3room() {
        return p1room;
    }

    String getp3subject() {
        return p1subject;
    }

    String getp4room() {
        return p1room;
    }

    String getp4subject() {
        return p1subject;
    }

    void setCycle(int cycle) {
        this.cycle = cycle;
    }

    void setp1room(String p1room) {
        this.p1room = p1room;
    }

    void setp1subject(String p1subject) {
        this.p1subject = p1subject;
    }

    void setp2room(String p2room) {
        this.p2room = p2room;
    }

    void setp2subject(String p2subject) {
        this.p2subject = p2subject;
    }

    void setp3room(String p3room) {
        this.p3room = p3room;
    }

    void setp3subject(String p3subject) {
        this.p3subject = p3subject;
    }

    void setp4room(String p4room) {
        this.p4room = p4room;
    }

    void setp4subject(String p4subject) {
        this.p4subject = p4subject;
    }

}
