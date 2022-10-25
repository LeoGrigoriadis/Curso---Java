package clase09.repaso;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    ProductRepository productRepository; 
    
    // @Autowired
    // TableRepository tableRepo;

    // @GetMapping("/api/tables")
    // public String table2(){
    //     return "string";
    // }
    // @GetMapping("/api/table")
    // public ResponseEntity<?> table1(){
    //     Iterable<Table1> table = tableRepo.findAll();
    //     if (table != null) return ResponseEntity.ok().body("a");
    //     else return ResponseEntity.badRequest().body("b");
    // }

    @GetMapping("/api/product/{code}")
    public ResponseEntity<Product> findProduct(@PathVariable Long code){
        Optional<Product> product = productRepository.findById(code);
        if (product != null) return ResponseEntity.ok().body(product.get());
        else return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/api/products")
    public ResponseEntity<Iterable<Product>> findAllProduct(){
        Iterable<Product> products = productRepository.findAll();
        if(products != null) return ResponseEntity.ok().body(products);
        else return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/api/save")
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        if(product != null) {
            productRepository.save(product);
            return ResponseEntity.ok().body("Producto guardado correctamente.");
        }
        else return ResponseEntity.badRequest().body("Error al intentar guardar el producto.");
    }

    @PutMapping("/api/put")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        try{
            Product oldProduct = productRepository.findById(product.getCode()).get();
            oldProduct.setName(product.getName());
            productRepository.save(oldProduct);
            return ResponseEntity.ok().body("El producto ha sido modificado correctamente.");
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error al intentar modificar el producto.");
        }
        
    }
    @DeleteMapping("/api/remove/{code}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long code){
        try{
            productRepository.delete(productRepository.findById(code).get());
            return ResponseEntity.ok().body("Producto eliminado correctamente.");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error al intentar eliminar el producto.");
        }
    }
}
