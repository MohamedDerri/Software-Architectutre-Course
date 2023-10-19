package lab10.ProductQueryService.service;

import lab10.ProductQueryService.domain.ProductQuery;
import lab10.ProductQueryService.dto.ProductDto;
import lab10.ProductQueryService.repository.ProductQueryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService{
    private final ProductQueryRepository productQueryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductQuery> productQueries = productQueryRepository.findAll();
        return productQueries.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int productNumber) {
        ProductQuery product = productQueryRepository.findById(productNumber).orElse(null);
        return modelMapper.map(product, ProductDto.class);
    }
}
