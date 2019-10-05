package nl.voorth.woodwing;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class SimpleTest
{
  @Test
  public void testTest() {
    var format = new DecimalFormat("#.##########", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    assertThat(format.format(1.78)).isEqualTo("1.78");
  }
}
