package com.example.javaanything.pattern.creational;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResourceConfigTest {

  @Test
  void builder() {
    // given
    String name = "test";
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "1111";
    String driverClassName = "com.mysql.jdbc.Driver";

    // when
    ResourceConfig resourceConfig = ResourceConfig.builder()
      .name(name)
      .url(url)
      .username(username)
      .password(password)
      .driverClassName(driverClassName)
      .build();

    // then
    assertThat(resourceConfig).isNotNull();
    assertThat(resourceConfig.getName()).isEqualTo(name);
    assertThat(resourceConfig.getUrl()).isEqualTo(url);
    assertThat(resourceConfig.getUsername()).isEqualTo(username);
    assertThat(resourceConfig.getPassword()).isEqualTo(password);
    assertThat(resourceConfig.getDriverClassName()).isEqualTo(driverClassName);
  }
}
