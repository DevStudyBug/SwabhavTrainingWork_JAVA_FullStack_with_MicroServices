package com.aurionpro.Factory.HospitalSystem;

interface IMedicalReport {
    void generateReport();
}

class BloodTestReport implements IMedicalReport {
    @Override
    public void generateReport() {
        System.out.println("Generating Blood Test Report...");
    }
}

class XRayReport implements IMedicalReport {
    @Override
    public void generateReport() {
        System.out.println("Generating X-Ray Report...");
    }
}

class ReportFactory {
    public IMedicalReport getReport(String type) {
        if (type == null)
            return null;

        switch (type.toLowerCase()) {
            case "blood":
                return new BloodTestReport();
            case "xray":
                return new XRayReport();
            default:
                return null;
        }
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        ReportFactory factory = new ReportFactory();

        IMedicalReport report1 = factory.getReport("blood");
        if (report1 != null) report1.generateReport();

        IMedicalReport report2 = factory.getReport("xray");
        if (report2 != null) report2.generateReport();
    }
}