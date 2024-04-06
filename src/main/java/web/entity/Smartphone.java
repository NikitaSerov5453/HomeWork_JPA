package web.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.enums.SmartphoneManufacturer;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "smartphone")
public class Smartphone {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String model;

    @Enumerated(EnumType.STRING)
    @Column(name = "smartphone_manufacturer")
    private SmartphoneManufacturer smartphoneManufacturer;

    @OneToOne(cascade = {CascadeType.ALL})
    private Processor processor;

    public Smartphone setModel(String model) {
        this.model = model;
        return this;
    }

    public Smartphone setSmartphoneManufacturer(SmartphoneManufacturer smartphoneManufacturer) {
        this.smartphoneManufacturer = smartphoneManufacturer;
        return this;
    }

    public Smartphone setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }
}
