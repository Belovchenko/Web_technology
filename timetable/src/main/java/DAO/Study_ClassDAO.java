package DAO;

import entities.Study_Class;

public interface Study_ClassDAO
{
    Study_Class findById(int id);
    void addStudy_Class(Study_Class study_class);
    void updateStudy_Class(Study_Class study_class);
    void deleteStudy_Class(Study_Class study_class);
}
