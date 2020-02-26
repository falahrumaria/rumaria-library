package rumaria.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

  @Test
  void romanToIntTest() {
    assertThrows(IllegalArgumentException.class, () -> RomanNumeral.romanToInt("MMMM"));
    assertEquals(1434, RomanNumeral.romanToInt("MCDXXXIV"));
  }
}