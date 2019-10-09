package nl.voorth.woodwing;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Pattern;

public class Distance
{
  private static final DecimalFormat FORMAT = new DecimalFormat("#.############", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

  public final double value;
  public final LengthUnit unit;

  Distance(double value, LengthUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public Distance convertTo(LengthUnit toUnit) {
    var from = unit.value;
    var to = toUnit.value;

    return new Distance(value * from / to , toUnit);
  }

  public static Distance valueOf(String input) {
    String regex = "(?<value>-?(\\d+\\.)?\\d*)(?<unit>\\p{Alpha}*)";
    var pattern = Pattern.compile(regex);
    var matcher = pattern.matcher(input);
    if(!matcher.find())
      throw new IllegalArgumentException(String.format("'%s' is not a valid distance", input));
    String value = matcher.group("value");
    String unit = matcher.group("unit");
    return new Distance(Double.parseDouble(value), LengthUnit.of(unit));
  }

  public String toString() {
    return String.format("%s%s", FORMAT.format(value), unit.symbol);
  }
}
