package lab10.ProductCommandService.service;

import lab10.ProductCommandService.dto.ProductDto;

public interface ProductCommandService {
    void add(ProductDto productDto);
    void delete(int productNumber);
    void update(int productNumber, ProductDto productDto);
}
