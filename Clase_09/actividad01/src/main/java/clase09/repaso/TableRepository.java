package clase09.repaso;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository  extends CrudRepository <Table1, Integer>{ 

}
