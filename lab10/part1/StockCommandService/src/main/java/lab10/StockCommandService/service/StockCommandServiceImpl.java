package lab10.StockCommandService.service;

import lab10.StockCommandService.domain.StockCommand;
import lab10.StockCommandService.dto.StockDto;
import lab10.StockCommandService.integration.StockChangeEventSender;
import lab10.StockCommandService.repository.StockCommandRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockCommandServiceImpl implements StockCommandService{
    private final StockCommandRepository stockCommandRepository;
    private final ModelMapper modelMapper;
    private final StockChangeEventSender stockChangeEventSender;

    @Override
    public void addStock(StockDto stockDto) {
        StockCommand stock = modelMapper.map(stockDto, StockCommand.class);
        stockCommandRepository.save(stock);
        stockChangeEventSender.sendMessage(stockDto);
    }

    @Override
    public void deleteStock(int productNumber) {
        stockCommandRepository.deleteById(productNumber);
        stockChangeEventSender.sendMessage(new StockDto(productNumber, 0));
    }

    @Override
    public void updateStock(int productNumber, StockDto stockDto) {
        StockCommand stock = modelMapper.map(stockDto, StockCommand.class);
        stock.setProductNumber(productNumber);
        stockCommandRepository.save(stock);
        stockChangeEventSender.sendMessage(modelMapper.map(stock, StockDto.class));
    }
}
