package com.majustory.login;

import lombok.Data;

@Data
public class LoginVO {
  private String   pid;
  private String   username;
  private String   password;
  private String   role;
  private String   name;
  private String   pimg;
  private String   today;
}
