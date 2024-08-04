package com.example.javaanything.pattern.creational;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class ResourceConfig {

  private String name;
  private String url;
  private String username;
  private String password;
  private String driverClassName;

  public static ResourceConfig.Builder builder() {
    return new ResourceConfig.Builder();
  }

  public static class Builder {

    private String name;
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Builder username(String username) {
      this.username = username;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder driverClassName(String driverClassName) {
      this.driverClassName = driverClassName;
      return this;
    }

    public ResourceConfig build() {
      ResourceConfig resourceConfig = new ResourceConfig();
      resourceConfig.name = this.name;
      resourceConfig.url = this.url;
      resourceConfig.username = this.username;
      resourceConfig.password = this.password;
      resourceConfig.driverClassName = this.driverClassName;
      return resourceConfig;
    }
  }
}
