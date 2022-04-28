package ucb.edu.bo.projectrabbitmq.dto;

import ucb.edu.bo.projectrabbitmq.entity.Teacher;

public class TeacherDto {
    private int teacherId;
    private String name;
    private String email;
    private String phone;

    public TeacherDto() {
    }

    public TeacherDto(Teacher teacher) {
        teacherId = teacher.getTeacherId();
        name = teacher.getName();
        email = teacher.getEmail();
        phone = teacher.getPhone();

    }


    public TeacherDto(int teacherId, String name, String email, String phone) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public int getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "{" +
            " teacherId='" + getTeacherId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            "}";
    }
    
}
