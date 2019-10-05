package nl.voorth.woodwing;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

public enum LengthUnit
{
  METRE(1,  "m"),
  YARD(0.99,"yd"),
  KILOMETRE(1000, "km"),
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

  public static LengthUnit of(String symbol) {
    return lookup.getOrDefault(symbol, METRE);
  }

}
