package Java_backend.springstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String company;
    private int serial_number;
    private String color;
    private String size;
    private int price;
    private String county;
    private boolean online_order;
    private boolean credit;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}