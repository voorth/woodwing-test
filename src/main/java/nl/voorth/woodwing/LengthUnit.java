package nl.voorth.woodwing;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public enum LengthUnit
{
  METRE(1,  "m"),
  YARD(0.9144,"yd"),
  KILOMETRE(1000, "km"),
  MILE(1_609.344, "mi"),
  ;

  public final double value;
  public final String symbol;

  private final static Map<String, LengthUnit> lookup =
    Stream.of(LengthUnit.values())
    .collect(toMap(unit -> unit.symbol, identity()));

  LengthUnit(double value, String symbol)
  {
    this.value = value;
    this.symbol = symbol;
  }

  public static LengthUnit of(String symbol)
  {
    if(!lookup.containsKey(symbol))
      throw new IllegalArgumentException(String.format("'%s' is not a valid unit symbol", symbol));
    return lookup.get(symbol);
  }

}
