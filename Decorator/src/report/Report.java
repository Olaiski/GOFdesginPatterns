package report;

public interface Report {

    Object[][] getReportData(final String reportdId);
    String getFirstColumnData();
}
