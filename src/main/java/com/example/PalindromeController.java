package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {
  private static final Logger logger = LoggerFactory.getLogger(PalindromeController.class);

  @GetMapping("/checkPalindrome")
  public ResponseEntity<PalindromeResponse> checkPalindrome(@RequestParam String text) {
    logger.info("Checking palindrome for text: {}", text);
    if (text == null || text.isEmpty()) {
      return ResponseEntity.badRequest().body(new PalindromeResponse(false));
    }

    boolean isPalindrome = new StringBuilder(text).reverse().toString().equals(text);
    return ResponseEntity.ok(new PalindromeResponse(isPalindrome));
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<String> handleException(Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
  }
}
