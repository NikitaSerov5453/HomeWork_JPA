package web.dao;

import web.entity.Smartphone;

import java.util.List;
import java.util.UUID;

public interface SmartphoneDao {

    void createTable();

    void dropTable();

    void saveSmartphone(Smartphone smartphone);

    void deleteSmartphoneById(UUID id);

    void updateSmartphone(Smartphone smartphone);

    void printAllEntity();

    void addNewSmartphone(Smartphone smartphone);

    Smartphone findSmartphoneById(UUID id);

    List<Smartphone> getAll();
}
