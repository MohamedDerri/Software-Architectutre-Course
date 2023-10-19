package lab10.ProductQueryService.controller;

import lab10.ProductQueryService.dto.ProductDto;
import lab10.ProductQueryService.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductQueryController {
    private final ProductQueryService productQueryService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        List<ProductDto> products = productQueryService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/{productNumber}")
    public ResponseEntity<?> getAllProducts(@PathVariable int productNumber){
        ProductDto product = productQueryService.getProductById(productNumber);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
