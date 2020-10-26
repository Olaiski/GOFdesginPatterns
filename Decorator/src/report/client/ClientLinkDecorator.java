package report.client;

import report.ColumnDecorator;
import report.Report;

public class ClientLinkDecorator extends ColumnDecorator {

    public ClientLinkDecorator(Report decoratedReport) {
        super(decoratedReport);
    }

    public String getFirstColumnData() {
        return addMoreInfo(super.getFirstColumnData());
    }

    private String addMoreInfo(String data) {
        return data + " client link - ";
    }


}
