package clase09.repaso;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table( name = "table1")
public class Table1 {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    
}
