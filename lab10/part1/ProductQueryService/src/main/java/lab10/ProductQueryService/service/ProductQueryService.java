package lab10.ProductQueryService.service;

import lab10.ProductQueryService.dto.ProductDto;

import java.util.List;

public interface ProductQueryService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(int productNumber);
}
