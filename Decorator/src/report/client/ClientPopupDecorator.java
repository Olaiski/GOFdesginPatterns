package report.client;

import report.ColumnDecorator;
import report.Report;

public class ClientPopupDecorator extends ColumnDecorator {

    public ClientPopupDecorator(Report decoratedReport) {
        super(decoratedReport);
    }

    public String getFirstColumnData() {
        return addPopup(super.getFirstColumnData());
    }

    private String addPopup(String data) {
        return data + " - client popup -";
    }
}
