
package com.esquelas.entities;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Student {
   private String name;
   private String email;
   private List<Course> courseList = new ArrayList<>();
   private JRBeanCollectionDataSource coursedatasource;

    public Student() {
    }

    public Student(String name, String email, JRBeanCollectionDataSource coursedatasource) {
        this.name = name;
        this.email = email;
        this.coursedatasource = coursedatasource;
    }
 
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public String getEmail() {
       return email;
   }
   public void setEmail(String email) {
       this.email = email;
   }
   public List<Course> getCourseList() {
       return courseList;
   }
   public void setCourseList(List<Course> courseList) {
       this.courseList = courseList;
   }
   public JRBeanCollectionDataSource getCoursedatasource() {
       return new JRBeanCollectionDataSource(courseList, false);
   }
}