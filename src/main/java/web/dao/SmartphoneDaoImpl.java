package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.Smartphone;

import java.util.List;
import java.util.UUID;

@Repository
public class SmartphoneDaoImpl implements SmartphoneDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createTable() {
        String smartphoneTable = """
                CREATE TABLE IF NOT EXISTS Smartphone (
                id UUID PRIMARY KEY,
                model VARCHAR(40),
                smartphone_manufacturer VARCHAR(40),
                processor_id UUID
                )
                """;
        String processorTable = """
                CREATE TABLE IF NOT EXISTS Processor (
                id UUID PRIMARY KEY,
                model INTEGER,
                name VARCHAR(40),
                cores INTEGER,
                frequency INTEGER,
                processor_manufacturer VARCHAR(40)
                )
                """;

        entityManager.createNativeQuery(smartphoneTable).executeUpdate();
        entityManager.createNativeQuery(processorTable).executeUpdate();
    }

    @Override
    @Transactional
    public void dropTable() {
        String smartphoneTable = """
                DROP TABLE IF EXISTS Smartphone;
                """;

        String processorTable = """
                DROP TABLE IF EXISTS Processor;
                """;
        entityManager.createNativeQuery(smartphoneTable).executeUpdate();
        entityManager.createNativeQuery(processorTable).executeUpdate();
    }

    @Override
    @Transactional
    public void saveSmartphone(Smartphone smartphone) {
        entityManager.persist(smartphone);
    }

    @Override
    @Transactional
    public void deleteSmartphoneById(UUID id) {
        entityManager.remove(entityManager.find(Smartphone.class, id));
    }

    @Override
    @Transactional
    public void updateSmartphone(Smartphone smartphone) {
        entityManager.merge(smartphone);
    }

    @Override
    public void printAllEntity() {
        getAll().forEach(System.out::println);
    }

    @Override
    @Transactional
    public void addNewSmartphone(Smartphone smartphone) {
        entityManager.persist(smartphone);
    }

    @Override
    public Smartphone findSmartphoneById(UUID id) {
        return entityManager.find(Smartphone.class, id);
    }

    @Override
    public List<Smartphone> getAll() {
        String sql = "SELECT s FROM Smartphone s";

        TypedQuery<Smartphone> query = entityManager.createQuery(sql, Smartphone.class);
        return query.getResultList();
    }
}
