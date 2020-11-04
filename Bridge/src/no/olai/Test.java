package no.olai;

import no.olai.repository.DatabaseRepository;
import no.olai.repository.FileRepository;
import no.olai.repository.LogRepository;

public class Test {
    public static void main(String[] args) {

        DatabaseRepository.getInstance().open();



        LogMessage l1 = new LogMessage("Log test 1");
        LogMessage l2 = new LogMessage("Log test 2");
        LogMessage l3 = new LogMessage("Log test 3");
        LogMessage l4 = new LogMessage("Log test 4");

        LogRepository fileRepo = new LogRepository(new FileRepository());
        fileRepo.save(l1);
        fileRepo.save(l2);
        fileRepo.save(l3);
        fileRepo.save(l4);

        LogRepository dbRepo = new LogRepository(DatabaseRepository.getInstance());
        dbRepo.save(l1);
        dbRepo.save(l2);
        dbRepo.save(l3);
        dbRepo.save(l4);



        DatabaseRepository.getInstance().close();

    }
}
