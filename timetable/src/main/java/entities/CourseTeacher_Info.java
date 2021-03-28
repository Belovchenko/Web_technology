package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "CourseTeacher_Info")
public class CourseTeacher_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private int course_sem;

    public CourseTeacher_Info() {}

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

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public int getCourse_sem()
    {
        return course_sem;
    }

    public void setCourse_sem(int course_sem)
    {
        this.course_sem = course_sem;
    }

    @Override
    public String toString()
    {
        return "CourseTeacher_Info{" +
                "id=" + id +
                ", course=" + course +
                ", teacher=" + teacher +
                ", course_sem=" + course_sem +
                '}';
    }
}
