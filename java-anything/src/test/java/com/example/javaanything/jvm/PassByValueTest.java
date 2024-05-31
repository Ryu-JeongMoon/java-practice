package com.example.javaanything.jvm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PassByValueTest {

  private Obj first, second;

  @Test
  void passByValue() {
    // given
    first = new Obj(1);
    second = new Obj(2);

    assertThat(first.value).isEqualTo(1);
    assertThat(second.value).isEqualTo(2);

    // when
    modify(first, second);

    // then
    assertThat(first).isNotEqualTo(second);
  }

  // second address is passed by value, not reference
  private void modify(Obj first, Obj second) {
    assertThat(second).isEqualTo(this.second);

    first.value = 111;
    second = first;

    assertThat(second).isEqualTo(this.first);
    assertThat(second).isNotEqualTo(this.second);
  }

  private static class Obj {

    private int value;

    public Obj(int value) {
      this.value = value;
    }
  }
}
