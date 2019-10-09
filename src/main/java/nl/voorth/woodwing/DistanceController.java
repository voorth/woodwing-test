package nl.voorth.woodwing;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistanceController
{
  @GetMapping("distance")
  public String addDistances(
    @RequestParam(required = false, defaultValue = "0m") List<String> dist,
    @RequestParam(required = false, defaultValue = "m") String unit)
  {
    var lengthUnit = LengthUnit.of(unit);
    var totalDistance = dist.stream()
      .map(Distance::valueOf)
      .map(d -> d.convertTo(lengthUnit))
      .mapToDouble(d -> d.value)
      .sum();

    return new Distance(totalDistance, lengthUnit).toString();
  }
}
