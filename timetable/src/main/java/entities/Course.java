package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Course")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    private String course_name;
    private int coverage;
    private int year;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseStudent_Info> course_student_info;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseTeacher_Info> course_teacher_info;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Study_Class> course_study_info;

    public Course() {}

    public Course(String name, int coverage, int year)
    {
        this.course_name = name;
        this.coverage = coverage;
        this.year = year;
        course_student_info = new HashSet<>();
        course_teacher_info = new HashSet<>();
        course_study_info = new HashSet<>();
    }

    public int getCourse_id()
    {
        return course_id;
    }

    public void setCourse_id(int course_id)
    {
        this.course_id = course_id;
    }

    public String getCourse_name()
    {
        return course_name;
    }

    public void setCourse_name(String course_name)
    {
        this.course_name = course_name;
    }

    public int getCoverage()
    {
        return coverage;
    }

    public void setCoverage(int coverage)
    {
        this.coverage = coverage;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public Set<CourseStudent_Info> getCourse_student_info() {
        return course_student_info;
    }

    public void setCourse_student_info(Set<CourseStudent_Info> course_student_info) {
        this.course_student_info = course_student_info;
    }

    public Set<CourseTeacher_Info> getCourse_teacher_info() {
        return course_teacher_info;
    }

    public void setCourse_teacher_info(Set<CourseTeacher_Info> course_teacher_info) {
        this.course_teacher_info = course_teacher_info;
    }

}
