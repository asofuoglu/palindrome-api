package com.example;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MoneyTransferController {

  private final Map<String, User> customerStore = new HashMap<>();

  @Autowired
  public MoneyTransferController(CustomerConfig customerConfig) {
    initializeCustomerStore(customerConfig);
  }

  private void initializeCustomerStore(CustomerConfig customerConfig) {
    for (User user : customerConfig.getCustomers()) {
      customerStore.put(user.getName(), user);
    }
  }

  @PostMapping("/validate")
  public Map<String, Boolean> validateUser(@RequestBody User inputUser) {
    boolean isTransferCompleted = isTransferValid(inputUser);
    return createResponse(isTransferCompleted);
  }

  private boolean isTransferValid(User inputUser) {
    User storedUser = customerStore.get(inputUser.getName());
    return storedUser != null
        && storedUser.getOriginatorName().equalsIgnoreCase(inputUser.getOriginatorName())
        && storedUser.getLinkedAccount().equalsIgnoreCase(inputUser.getLinkedAccount())
        && storedUser.getCoowner().equalsIgnoreCase(inputUser.getCoowner());
  }

  private Map<String, Boolean> createResponse(boolean isTransferCompleted) {
    Map<String, Boolean> response = new HashMap<>();
    response.put("transfer_completed", isTransferCompleted);
    return response;
  }
}
