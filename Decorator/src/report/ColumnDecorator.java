package report;

public abstract class ColumnDecorator implements Report {

    private Report decoratedReport;

    public ColumnDecorator(Report decoratedReport) {
        this.decoratedReport = decoratedReport;
    }

    @Override
    public Object[][] getReportData(String reportdId) {
        return decoratedReport.getReportData(reportdId);
    }

    @Override
    public String getFirstColumnData() {
        return decoratedReport.getFirstColumnData();
    }
}
