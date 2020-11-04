package no.olai.repository;

import no.olai.LogMessage;

public class LogRepository implements BaseRepository {

    private StorageRepository repository;

    public LogRepository(StorageRepository repository) {
        this.repository = repository;
    }

    @Override
    public StorageRepository getRepository() {
        return repository;
    }

    @Override
    public void save(LogMessage message) {
        if (message == null || message.getMessage().length() < 1)
            return;

        repository.store(message);
    }
}
