package no.olai.repository;

import no.olai.LogMessage;

public interface StorageRepository {

    void store(LogMessage message);

}
