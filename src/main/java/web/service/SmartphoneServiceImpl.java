package web.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import web.dao.SmartphoneDao;
import web.entity.Processor;
import web.entity.Smartphone;
import web.enums.ProcessorManufacturer;
import web.enums.SmartphoneManufacturer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class SmartphoneServiceImpl implements SmartphoneService {

    private final SmartphoneDao smartphoneDao;
    private boolean flag;

    @Override
    public void createTable() {
        smartphoneDao.createTable();
    }

    @Override
    public void dropTable() {
        smartphoneDao.dropTable();
    }

    @Override
    public void saveSmartphone(Smartphone smartphone) {
        smartphoneDao.saveSmartphone(smartphone);
    }

    @Override
    public void deleteSmartphoneById(UUID id) {
        smartphoneDao.deleteSmartphoneById(id);
    }

    @Override
    public void updateSmartphone(Smartphone smartphone) {
        smartphoneDao.updateSmartphone(smartphone);
    }

    private void initializingTable() {
        Smartphone iphone = Smartphone.builder()
                .model("iPhone 15 Pro Max")
                .smartphoneManufacturer(SmartphoneManufacturer.APPLE)
                .processor(Processor.builder()
                        .model(17)
                        .name("Apple A17 Pro")
                        .cores(6)
                        .frequency(3780)
                        .processorManufacturer(ProcessorManufacturer.APPLE)
                        .build())
                .build();

        Smartphone huawei = Smartphone.builder()
                .model("Huawei P60 Pro")
                .smartphoneManufacturer(SmartphoneManufacturer.HUAWEI)
                .processor(Processor.builder()
                        .model(8)
                        .name("Snapdragon 8+ Gen 1")
                        .cores(8)
                        .frequency(3190)
                        .processorManufacturer(ProcessorManufacturer.QUALCOMM)
                        .build())
                .build();

        Smartphone xiaomi = Smartphone.builder()
                .model("Xiaomi 14 pro")
                .smartphoneManufacturer(SmartphoneManufacturer.XIAOMI)
                .processor(Processor.builder()
                        .model(8)
                        .name("Qualcomm Snapdragon 8 Gen 3")
                        .cores(8)
                        .frequency(3300)
                        .processorManufacturer(ProcessorManufacturer.QUALCOMM)
                        .build())
                .build();

        Smartphone samsung = Smartphone.builder()
                .model("Samsung Galaxy S24 Ultra")
                .smartphoneManufacturer(SmartphoneManufacturer.SAMSUNG)
                .processor(Processor.builder()
                        .model(8)
                        .name("Qualcomm Snapdragon 8 Gen 3")
                        .cores(8)
                        .frequency(3390)
                        .processorManufacturer(ProcessorManufacturer.QUALCOMM)
                        .build())
                .build();

        Smartphone oppo = Smartphone.builder()
                .model("Find X7 Ultra")
                .smartphoneManufacturer(SmartphoneManufacturer.XIAOMI)
                .processor(Processor.builder()
                        .model(8)
                        .name("Qualcomm Snapdragon 8 Gen 3")
                        .cores(8)
                        .frequency(3300)
                        .processorManufacturer(ProcessorManufacturer.QUALCOMM)
                        .build())
                .build();

        Smartphone samsung2 = Smartphone.builder()
                .model("Samsung Galaxy S23 FE")
                .smartphoneManufacturer(SmartphoneManufacturer.SAMSUNG)
                .processor(Processor.builder()
                        .model(2200)
                        .name("Samsung Exynos 2200")
                        .cores(8)
                        .frequency(2800)
                        .processorManufacturer(ProcessorManufacturer.SAMSUNG)
                        .build())
                .build();

        Smartphone xiaomi2 = Smartphone.builder()
                .model("Xiaomi Redmi Note 13 Pro")
                .smartphoneManufacturer(SmartphoneManufacturer.XIAOMI)
                .processor(Processor.builder()
                        .model(99)
                        .name("MediaTek Helio G99-Ultra")
                        .cores(8)
                        .frequency(2200)
                        .processorManufacturer(ProcessorManufacturer.MEDIA_TEK)
                        .build())
                .build();

        smartphoneDao.saveSmartphone(iphone);
        smartphoneDao.saveSmartphone(huawei);
        smartphoneDao.saveSmartphone(xiaomi);
        smartphoneDao.saveSmartphone(samsung);
        smartphoneDao.saveSmartphone(oppo);
        smartphoneDao.saveSmartphone(samsung2);
        smartphoneDao.saveSmartphone(xiaomi2);
    }

    @Override
    public void initialize() {
        if (!flag) {
            initializingTable();
            flag = true;
        }
    }

    @Override
    public void printAllEntity() {
        smartphoneDao.printAllEntity();
    }

    @Override
    public void addNewSmartphone(Smartphone smartphone) {
        smartphoneDao.addNewSmartphone(smartphone);
    }

    @Override
    public Smartphone findSmartphoneById(UUID id) {
        return smartphoneDao.findSmartphoneById(id);
    }

    @Override
    public List<Smartphone> getAll() {
        return smartphoneDao.getAll();
    }

    @Override
    public List<Smartphone> findSmartphoneByManufacturer(String manufacturer) {
        List<Smartphone> smartphones = new ArrayList<>();
        for (Smartphone smartphone : smartphoneDao.getAll()) {
            if (smartphone.getSmartphoneManufacturer() == SmartphoneManufacturer.valueOf(manufacturer)) {
                smartphones.add(smartphone);
            }
        }
        return smartphones;
    }

    @Override
    public Long countingAllEntitiesInDatabase() {
        return (long) smartphoneDao.getAll().size();
    }
}
