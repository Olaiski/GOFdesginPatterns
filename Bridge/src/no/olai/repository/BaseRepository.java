package no.olai.repository;

import no.olai.LogMessage;

public interface BaseRepository {

    void save(LogMessage message);
    StorageRepository getRepository();
}
