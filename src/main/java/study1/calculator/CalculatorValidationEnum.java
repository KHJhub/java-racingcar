package study1.calculator;

import java.util.Arrays;

import org.junit.platform.commons.util.StringUtils;

public enum CalculatorValidationEnum {
  EMPTY_CHECK(1) {
    @Override
    public void check(String str) {
      if (StringUtils.isBlank(str)) {
        throw new IllegalArgumentException("null or empty error");
      }
    }
  },
  INT_CHECK(0) {
    @Override
    public void check(String str) {
      try {
        Integer.parseInt(str);
      } catch (Exception e) {
        throw new IllegalArgumentException("not int error");
      }
    }
  };

  public abstract void check(String str);

  private final int index;

  CalculatorValidationEnum(int index) {
    this.index = index % 2;
  }

  public static CalculatorValidationEnum fromIndex(int index) {
    return Arrays.stream(CalculatorValidationEnum.values()).filter((validation) -> validation.index == (index % 2))
        .findAny().orElseThrow(() -> new IllegalArgumentException("not int error"));
  }

  public void checkSomeThing(String str) {
    this.check(str);
  }

}