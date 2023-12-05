package aoc.day5;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import org.jetbrains.annotations.NotNull;

public class Almanac {
  List<Long> seeds = new ArrayList<>();
  RangeMap<Long, Long> soilRangeAdjustmentMap = TreeRangeMap.create();
  RangeMap<Long, Long> fertilizerRangeAdjustmentMap = TreeRangeMap.create();
  RangeMap<Long, Long> waterRangeAdjustmentMap = TreeRangeMap.create();
  RangeMap<Long, Long> lightRangeAdjustmentMap = TreeRangeMap.create();
  RangeMap<Long, Long> temperatureRangeAdjustmentMap = TreeRangeMap.create();
  RangeMap<Long, Long> humidityRangeAdjustmentMap = TreeRangeMap.create();
  RangeMap<Long, Long> locationRangeAdjustmentMap = TreeRangeMap.create();

  Almanac() {
    // Just for tests.
  }

  public Almanac(String filename) throws FileNotFoundException {
    String filepath = Objects.requireNonNull(getClass().getResource(filename)).getFile();
    Scanner scanner = new Scanner(new File(filepath));

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] tokens = line.split(":");
      switch (tokens[0]) {
        case "seeds":
          addSeeds(tokens[1].trim());
          break;
        case "seed-to-soil map":
          loadMap(soilRangeAdjustmentMap, readMapData(scanner));
          break;
        case "soil-to-fertilizer map":
          loadMap(fertilizerRangeAdjustmentMap, readMapData(scanner));
          break;
        case "fertilizer-to-water map":
          loadMap(waterRangeAdjustmentMap, readMapData(scanner));
          break;
        case "water-to-light map":
          loadMap(lightRangeAdjustmentMap, readMapData(scanner));
          break;
        case "light-to-temperature map":
          loadMap(temperatureRangeAdjustmentMap, readMapData(scanner));
          break;
        case "temperature-to-humidity map":
          loadMap(humidityRangeAdjustmentMap, readMapData(scanner));
          break;
        case "humidity-to-location map":
          loadMap(locationRangeAdjustmentMap, readMapData(scanner));
          break;
      }
    }
  }

  List<String> readMapData(Scanner scanner) {
    List<String> mappingStrings = new ArrayList<>();
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if (line.isBlank()) {
        return mappingStrings;
      }
      mappingStrings.add(line);
    }
    return mappingStrings;
  }

  void addSeeds(String seedList) {
    for (String seedString : seedList.split(" ")) {
      seeds.add(Long.parseLong(seedString.trim()));
    }
  }

  void loadMap(RangeMap<Long, Long> rangeMapToLoad, List<String> mappingStrings) {
    for (String mappingString : mappingStrings) {
      String[] tokens = mappingString.split(" ");
      long destinationRangeStart = Long.parseLong(tokens[0].trim());
      long sourceRangeStart = Long.parseLong(tokens[1].trim());
      long rangeSize = Long.parseLong(tokens[2].trim());
      loadRangeAdjustmentMap(rangeMapToLoad, destinationRangeStart, sourceRangeStart, rangeSize);
    }
  }

  void loadRangeAdjustmentMap(
      @NotNull RangeMap<Long, Long> mapToLoad,
      long destinationRangeStart,
      long sourceRangeStart,
      long rangeSize) {
    mapToLoad.put(
        Range.closed(sourceRangeStart, sourceRangeStart + rangeSize - 1),
        destinationRangeStart - sourceRangeStart);
  }

  long getSoilForSeed(long seed) {
    Long adjustment = soilRangeAdjustmentMap.get(seed);
    if (adjustment == null) {
      return seed;
    }
    return seed + adjustment;
  }

  long getFertilizerForSoil(long soil) {
    Long adjustment = fertilizerRangeAdjustmentMap.get(soil);
    if (adjustment == null) {
      return soil;
    }
    return soil + adjustment;
  }

  long getWaterForFertilizer(long fertilizer) {
    Long adjustment = waterRangeAdjustmentMap.get(fertilizer);
    if (adjustment == null) {
      return fertilizer;
    }
    return fertilizer + adjustment;
  }

  long getLightForWater(long water) {
    Long adjustment = lightRangeAdjustmentMap.get(water);
    if (adjustment == null) {
      return water;
    }
    return water + adjustment;
  }

  long getTemperatureForLight(long light) {
    Long adjustment = temperatureRangeAdjustmentMap.get(light);
    if (adjustment == null) {
      return light;
    }
    return light + adjustment;
  }

  long getHumidityForTemperature(long temperature) {
    Long adjustment = humidityRangeAdjustmentMap.get(temperature);
    if (adjustment == null) {
      return temperature;
    }
    return temperature + adjustment;
  }

  long getLocationForHumidity(long humidity) {
    Long adjustment = locationRangeAdjustmentMap.get(humidity);
    if (adjustment == null) {
      return humidity;
    }
    return humidity + adjustment;
  }

  public long getLocationForSeed(long seed) {
    return getLocationForHumidity(
        getHumidityForTemperature(
            getTemperatureForLight(
                getLightForWater(
                    getWaterForFertilizer(getFertilizerForSoil(getSoilForSeed(seed)))))));
  }

  public long getClosestLocation() {
    long closestLocation = Long.MAX_VALUE;
    for (Long seed : seeds) {
      closestLocation = Math.min(closestLocation, getLocationForSeed(seed));
    }
    return closestLocation;
  }
}
