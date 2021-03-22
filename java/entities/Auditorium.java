package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Auditorium")
public class Auditorium
{
    @Id
    private int auditorium_num;

    @OneToMany(mappedBy = "auditorium_num", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Study_Class> study_auditorium_info;

    private int capacity;

    public Auditorium() {}

    public Auditorium(int num, int capacity)
    {
        this.auditorium_num = num;
        this.capacity = capacity;
        study_auditorium_info = new HashSet<>();
    }

    public int getAuditorium_num()
    {
        return auditorium_num;
    }

    public void setAuditorium_num(int auditorium_num)
    {
        this.auditorium_num = auditorium_num;
    }

    public Set<Study_Class> getStudy_auditorium_info()
    {
        return study_auditorium_info;
    }

    public void setStudy_auditorium_info(Set<Study_Class> study_auditorium_info)
    {
        this.study_auditorium_info = study_auditorium_info;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public String toString()
    {
        return "Auditorium{" +
                "auditorium_num=" + auditorium_num +
                ", study_auditorium_info=" + study_auditorium_info +
                ", capacity=" + capacity +
                '}';
    }
}
