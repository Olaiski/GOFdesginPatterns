package report.client;

import report.Report;

public class ClientReport implements Report {

    @Override
    public Object[][] getReportData(String reportdId) {
        return null;
    }

    @Override
    public String getFirstColumnData() {
        return "Client Data";
    }
}
