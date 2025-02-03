package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "customer")
public class CustomerConfig {
  private List<User> customers;

  public List<User> getCustomers() {
    return customers;
  }

  public void setCustomers(List<User> customers) {
    this.customers = customers;
  }
}
