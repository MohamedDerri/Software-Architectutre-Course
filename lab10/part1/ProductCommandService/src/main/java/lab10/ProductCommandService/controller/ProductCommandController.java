package lab10.ProductCommandService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab10.ProductCommandService.dto.ProductDto;
import lab10.ProductCommandService.service.ProductCommandService;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
    
	@Autowired
	private ProductCommandService productCommandService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDto productDto){
        productCommandService.add(productDto);
        return new ResponseEntity<>("Product added", HttpStatus.OK);
    }

    @PutMapping("/{productNumber}")
    public ResponseEntity<?> add(@PathVariable int productNumber, @RequestBody ProductDto productDto){
        productCommandService.update(productNumber, productDto);
        return new ResponseEntity<>("Product updated", HttpStatus.OK);
    }

    @DeleteMapping("/{productNumber}")
    public ResponseEntity<?> add(@PathVariable int productNumber){
        productCommandService.delete(productNumber);
        return new ResponseEntity<>("Product deleted", HttpStatus.OK);
    }
}
