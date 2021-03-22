package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Study_Class")
public class Study_Class
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int class_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_num")
    private Auditorium auditorium;

    private java.sql.Timestamp time;

    public Study_Class() {}

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id)
    {
        this.class_id = class_id;
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

    public Auditorium getAuditorium()
    {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium)
    {
        this.auditorium = auditorium;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time)
    {
        this.time = time;
    }

    @Override
    public String toString()
    {
        return "Study_Class{" +
                "class_id=" + class_id +
                ", course=" + course +
                ", teacher=" + teacher +
                ", auditorium=" + auditorium +
                ", time=" + time +
                '}';
    }
}

