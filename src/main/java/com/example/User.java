package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String name;
  private String originatorName;
  private String description;
  private String type;
  private String coowner;
  private String savingAccount;
  private String linkedAccount;
}
