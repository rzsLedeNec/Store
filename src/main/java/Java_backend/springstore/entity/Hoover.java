package Java_backend.springstore.entity;

import Java_backend.springstore.model.Product;
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
public class Hoover {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String dust_container;
    private String operating_mode;
    @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}