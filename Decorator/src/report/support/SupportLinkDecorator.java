package report.support;

import report.ColumnDecorator;
import report.Report;

public class SupportLinkDecorator extends ColumnDecorator {

    public SupportLinkDecorator(Report decoratedReport) {
        super(decoratedReport);
    }


    public String getFirstColumnData() {
        return addMoreInfo(super.getFirstColumnData());
    }

    private String addMoreInfo(String data) {
        return data + " - support link - ";
   }
}
