package edu.miu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.miu.dto.TransactionDto;

@FeignClient(name="saving-account", url="http://localhost:8081/saving-account")
public interface SavingAccountFeignClient extends AccountFeignClient {

}
