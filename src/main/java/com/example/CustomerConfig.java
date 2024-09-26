package com.example;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "customer")
public class CustomerConfig {
  private List<User> customers; // Ensure this is a List<User>

  public List<User> getCustomers() {
    return customers;
  }

  public void setCustomers(List<User> customers) {
    this.customers = customers;
  }
}
