package edu.miu.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.miu.dto.TransactionDto;

public interface AccountFeignClient {
    @PostMapping("/deposit")
    ResponseEntity<String> deposit(@RequestBody TransactionDto transactionDto);
    @PostMapping("/withdraw")
    ResponseEntity<String>  withdraw(@RequestBody TransactionDto transactionDto);
}
