package report.support;

import report.ColumnDecorator;
import report.Report;

public class SupportPopupDecorator extends ColumnDecorator {

    public SupportPopupDecorator(Report decoratedReport) {
        super(decoratedReport);
    }


    public String getFirstColumnData() {
        return addPopup(super.getFirstColumnData());
    }

    private String addPopup(String data) {
        return data + " - support popup -";
    }
}
