package com.esquelas.entities;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class StudentReportInput {

    private String reportTitle;
    private String instituteName;
    private JRBeanCollectionDataSource studentDataSource;

    public StudentReportInput() {
    }

    public StudentReportInput(String reportTitle, String instituteName, JRBeanCollectionDataSource studentDataSource) {
        this.reportTitle = reportTitle;
        this.instituteName = instituteName;
        this.studentDataSource = studentDataSource;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public JRBeanCollectionDataSource getStudentDataSource() {
        return studentDataSource;
    }

    public void setStudentDataSource(JRBeanCollectionDataSource studentDataSource) {
        this.studentDataSource = studentDataSource;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("P_INSTITUTE_NAME", getInstituteName());

        return parameters;
    }

    public Map<String, Object> getDataSources() {
        Map<String, Object> dataSources = new HashMap<>();
        dataSources.put("studentDataSource", studentDataSource);
        return dataSources;
    }
}
