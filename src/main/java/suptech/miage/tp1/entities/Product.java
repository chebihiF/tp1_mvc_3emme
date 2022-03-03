package suptech.miage.tp1.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id @Column(length =100)
    private String ref;
    private String label ;
    private double price;
    private int quantity;
}
