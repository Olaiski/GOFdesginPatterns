package no.olai;

import no.olai.repository.DatabaseRepository;
import no.olai.repository.FileRepository;
import no.olai.repository.LogRepository;

public class Test {
    public static void main(String[] args) {




        LogMessage l1 = new LogMessage("Log test 1");
        LogMessage l2 = new LogMessage("Log test 2");
        LogMessage l3 = new LogMessage("Log test 3");
        LogMessage l4 = new LogMessage("Log test 4");

        // Save to txt file
        LogRepository repo = new LogRepository(new FileRepository());
        repo.save(l1);
        repo.save(l2);
        repo.save(l3);
        repo.save(l4);




        // Save to DB
//        DatabaseRepository dbRepo = new DatabaseRepository();
//        dbRepo.open();
        DatabaseRepository.getInstance().open();

        repo = new LogRepository(DatabaseRepository.getInstance());

        repo.save(l1);
        repo.save(l2);
        repo.save(l3);
        repo.save(l4);



        DatabaseRepository.getInstance().close();
//        dbRepo.close();

    }
}
