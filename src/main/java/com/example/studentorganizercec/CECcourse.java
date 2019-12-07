package com.example.studentorganizercec;

public class CECcourse {

    private String course;
    private String teacher;
    private String room;
    private String block;

    public CECcourse() {
        this("Course", "Teacher", "0", "A");
    }

    public CECcourse(String c, String t, String r, String b) {
        setCourse(c);
        setTeacher(t);
        setRoom(r);
        setBlock(b);
    }

    String getCourse() {
        return course;
    }

    String getTeacher() {
        return teacher;
    }

    String getRoom() {
        return room;
    }

    String getBlock() {
        return block;
    }

    void setCourse(String course) {
        this.course = course;
    }

    void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    void setRoom(String room) {
        this.room = room;
    }

    void setBlock(String block) {
        this.block = block;
    }

    @Override
    public String toString(){
        String s = getCourse() + "," + getTeacher() + "," + getRoom() + "," + getBlock();
        return s;
    }

}
