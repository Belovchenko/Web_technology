package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    private String student_name;
    private int study_year;
    private int group_num;
    private int study_stream;

    //@ManyToMany
    //@JoinTable(name = "CourseStudent_Info", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn (name = "student_id"))
    @OneToMany(mappedBy = "student_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseStudent_Info> courses;


    public Student() {}

    public Student(String name, int year, int group, int stream)
    {
        this.student_name = name;
        this.study_year = year;
        this.group_num = group;
        this.study_stream = stream;
        courses = new HashSet<>();
    }

    public Set<CourseStudent_Info> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<CourseStudent_Info> courses)
    {
        this.courses = courses;
    }

    public int getStudent_id()
    {
        return student_id;
    }

    public String getStudent_name()
    {
        return student_name;
    }

    public void setStudent_name(String name)
    {
        this.student_name = name;
    }

    public int getStudent_year()
    {
        return study_year;
    }

    public void setStudent_year(int year)
    {
        this.study_year = year;
    }

    public int getStudent_group()
    {
        return group_num;
    }

    public void setStudent_group(int group)
    {
        this.group_num = group;
    }

    public int getStudent_stream()
    {
        return study_stream;
    }

    public void setStudent_stream(int stream)
    {
        this.study_stream = stream;
    }

    /*@Override
    public String toString()
    {
        return "Student{" + "student_id = " + student_id + ", student_name = " +
                student_name + ", study_year = " + study_year + ", group_num = " +
                group_num + ", study_stream = " + study_stream + " courses: " + courses + "}";

    }*/

    @Override
    public String toString()
    {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", study_year=" + study_year +
                ", group_num=" + group_num +
                ", study_stream=" + study_stream +
                ", courses=" + courses +
                '}';
    }
}
