package edu.miu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.miu.dto.TransactionDto;


@FeignClient(name="checking-account", url="http://localhost:8080/checking-account")
public interface CheckingAccountFeignClient extends AccountFeignClient {
}
