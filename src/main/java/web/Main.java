package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.configurations.DBConfig;
import web.entity.Smartphone;
import web.enums.SmartphoneManufacturer;
import web.service.SmartphoneService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

        SmartphoneService service = context.getBean(SmartphoneService.class);

//        service.createTable();
//        service.initialize();
//        service.printAllEntity();
//        System.out.println(service.findSmartphoneById(UUID.fromString("03e68ed3-a51a-4129-9ebf-71beb9d91b36")));
//        service.deleteSmartphoneById(UUID.fromString("03e68ed3-a51a-4129-9ebf-71beb9d91b36"));
//        System.out.println(service.countingAllEntitiesInDatabase());
        System.out.println(service.findSmartphoneById(UUID.fromString("82e7ecd0-32eb-4f02-8f81-02900df5da11")));
        service.updateSmartphone(service.findSmartphoneById(UUID.fromString("82e7ecd0-32eb-4f02-8f81-02900df5da11"))
                .setModel("1")
                .setSmartphoneManufacturer(SmartphoneManufacturer.APPLE));
        System.out.println(service.findSmartphoneById(UUID.fromString("82e7ecd0-32eb-4f02-8f81-02900df5da11")));
    }
}
