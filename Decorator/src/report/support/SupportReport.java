package report.support;

import report.Report;

public class SupportReport implements Report {

    @Override
    public Object[][] getReportData(String reportdId) {
        return null;
    }

    @Override
    public String getFirstColumnData() {
        return "Support Data";
    }
}
