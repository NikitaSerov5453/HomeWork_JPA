package web.service;

import web.entity.Smartphone;

import java.util.List;
import java.util.UUID;

public interface SmartphoneService {

    void createTable();

    void dropTable();

    void saveSmartphone(Smartphone smartphone);

    void deleteSmartphoneById(UUID id);

    void updateSmartphone(Smartphone smartphone);

    void initialize();

    void printAllEntity();

    void addNewSmartphone(Smartphone smartphone);

    Smartphone findSmartphoneById(UUID id);

    List<Smartphone> getAll();

    List<Smartphone> findSmartphoneByManufacturer(String manufacturer);

    Long countingAllEntitiesInDatabase();
}
