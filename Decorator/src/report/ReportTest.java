package report;

import report.client.ClientLinkDecorator;
import report.client.ClientPopupDecorator;
import report.client.ClientReport;
import report.support.SupportLinkDecorator;
import report.support.SupportPopupDecorator;
import report.support.SupportReport;

public class ReportTest {
    public static void main(String[] args) {

        SupportPopupDecorator spd = new SupportPopupDecorator(new SupportLinkDecorator(new SupportReport()));

        System.out.println(spd.getFirstColumnData());

        ClientLinkDecorator cld = new ClientLinkDecorator(new ClientPopupDecorator(new ClientReport()));

        System.out.println(cld.getFirstColumnData());

    }
}
