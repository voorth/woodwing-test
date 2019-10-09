package nl.voorth.woodwing;

import org.junit.Test;

import static nl.voorth.woodwing.LengthUnit.*;
import static org.assertj.core.api.Assertions.*;

public class DistanceTest
{

  @Test
  public void valueOf()
  {
    var input = "1.78m";
    var distance = Distance.valueOf(input);
    assertThat(distance.value).isEqualTo(1.78);
    assertThat(distance.unit).isEqualTo(METRE);
    assertThat((distance.toString())).isEqualTo(input);
  }

  @Test(expected = IllegalArgumentException.class)
  public void unKnownUnit() {
    var input = "5in";
    var distance = Distance.valueOf(input);
  }

  @Test
  public void conversion()
  {
    var distance = Distance.valueOf("1.5km");
    var converted = distance.convertTo(METRE);
    assertThat(converted.value).isEqualTo(1500);
    assertThat(converted.unit).isEqualTo(METRE);
  }

  @Test
  public void allowNegativeDistances()
  {
    var distance = Distance.valueOf("-100m");
    assertThat(distance.value).isEqualTo(-100);
  }


}