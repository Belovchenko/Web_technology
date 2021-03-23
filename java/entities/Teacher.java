package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Teacher")
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacher_id;

    private String teacher_name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseTeacher_Info> course_teacher_info;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Study_Class> study_teacher_info;

    public Teacher() {}

    public Teacher(String name)
    {
        teacher_name = name;
        course_teacher_info = new HashSet<>();
        course_teacher_info = new HashSet<>();
    }

    public int getTeacher_id()
    {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id)
    {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name()
    {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name)
    {
        this.teacher_name = teacher_name;
    }

    public Set<CourseTeacher_Info> getCourse_teacher_info()
    {
        return course_teacher_info;
    }

    public void setCourse_teacher_info(Set<CourseTeacher_Info> course_teacher_info)
    {
        this.course_teacher_info = course_teacher_info;
    }

    public Set<Study_Class> getStudy_teacher_info() {
        return study_teacher_info;
    }

    public void setStudy_teacher_info(Set<Study_Class> study_teacher_info) {
        this.study_teacher_info = study_teacher_info;
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", course_teacher_info=" + course_teacher_info +
                ", course_teacher_info=" + course_teacher_info +
                '}';
    }
}