package web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.enums.ProcessorManufacturer;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "processor")
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private int model;

    private String name;

    private int cores;

    private int frequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "processor_manufacturer")
    private ProcessorManufacturer processorManufacturer;

    public Processor setModel(int model) {
        this.model = model;
        return this;
    }

    public Processor setName(String name) {
        this.name = name;
        return this;
    }

    public Processor setCores(int cores) {
        this.cores = cores;
        return this;
    }

    public Processor setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public Processor setProcessorManufacturer(ProcessorManufacturer processorManufacturer) {
        this.processorManufacturer = processorManufacturer;
        return this;
    }
}
