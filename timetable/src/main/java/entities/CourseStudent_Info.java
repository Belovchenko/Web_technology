package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "CourseStudent_Info")
public class CourseStudent_Info
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    private int course_sem;

    public CourseStudent_Info() {}

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public int getCourse_sem()
    {
        return course_sem;
    }

    public void setCourse_sem(int course_sem)
    {
        this.course_sem = course_sem;
    }

    public CourseStudent_Info(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    @Override
    public String toString()
    {
        return "CourseStudent_Info{" +
                "id=" + id +
                ", course=" + course +
                ", student=" + student +
                ", course_sem=" + course_sem +
                '}';
    }
}
