package lab10.ProductCommandService.service;

import lab10.ProductCommandService.domain.ProductCommand;
import lab10.ProductCommandService.dto.ProductDto;
import lab10.ProductCommandService.integration.ProductChangeEventSender;
import lab10.ProductCommandService.repository.ProductCommandRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductCommandRepository productCommandRepository;
    private final ModelMapper modelMapper;
    private final ProductChangeEventSender productChangeEventSender;

    @Override
    public void add(ProductDto productDto) {
        ProductCommand product = modelMapper.map(productDto, ProductCommand.class);
        productCommandRepository.save(product);
        productChangeEventSender.sendMessage("add", productDto);
    }

    @Override
    public void delete(int productNumber) {
        productCommandRepository.deleteById(productNumber);
        productChangeEventSender.sendMessage("delete", new ProductDto(productNumber, "", 0));
    }

    @Override
    public void update(int productNumber, ProductDto productDto) {
        ProductCommand product = modelMapper.map(productDto, ProductCommand.class);
        product.setProductNumber(productNumber);
        productCommandRepository.save(product);
        productChangeEventSender.sendMessage("update", productDto);
    }
}
