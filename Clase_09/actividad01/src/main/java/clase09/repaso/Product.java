package clase09.repaso;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table( name = "PRODUCTS")
public class Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long code;
    private String name;
}
