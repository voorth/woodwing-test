package nl.voorth.woodwing;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.accept.MediaTypeFileExtensionResolver;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest
{

  @Test
  public void valueOf()
  {
    var input = "1.78m";
    var distance = Distance.valueOf(input);
    assertThat(distance.value).isEqualTo(1.78);
    assertThat(distance.unit).isEqualTo(LengthUnit.METER);
    assertThat((distance.toString())).isEqualTo(input);
  }

  @Test
  public void testToString()
  {
  }
}