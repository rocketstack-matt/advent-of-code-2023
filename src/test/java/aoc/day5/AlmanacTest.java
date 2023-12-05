package aoc.day5;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlmanacTest {
  @Test
  void seed_without_map_entry_equals_seed_number() {
    Almanac almanac = new Almanac();
    almanac.seeds.addAll(List.of(79L, 14L, 55L, 13L));
    for (Long seed : almanac.seeds) {
      Assertions.assertEquals(seed, almanac.getSoilForSeed(seed));
    }
  }

  @Test
  void load_range_adjustment_map() {
    Almanac almanac = new Almanac();
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 50L, 98L, 2L);
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 52L, 50L, 48L);
    Assertions.assertEquals(50L, almanac.getSoilForSeed(98L));
    Assertions.assertEquals(51L, almanac.getSoilForSeed(99L));
    Assertions.assertEquals(52L, almanac.getSoilForSeed(50L));
    Assertions.assertEquals(99L, almanac.getSoilForSeed(97L));
  }

  @Test
  void seed_with_map_entry_equals_map_value() {
    Almanac almanac = new Almanac();
    almanac.seeds.addAll(List.of(79L, 14L, 55L, 13L));
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 50L, 98L, 2L);
    Assertions.assertEquals(50L, almanac.getSoilForSeed(98L));
    Assertions.assertEquals(51L, almanac.getSoilForSeed(99L));
  }

  @Test
  void seed_79_maps_to_soil_81() {
    Almanac almanac = new Almanac();
    almanac.seeds.addAll(List.of(79L, 14L, 55L, 13L));
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 50L, 98L, 2L);
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 52L, 50L, 48L);
    Assertions.assertEquals(81L, almanac.getSoilForSeed(79L));
  }

  @Test
  void seed_14_maps_to_soil_14() {
    Almanac almanac = new Almanac();
    almanac.seeds.addAll(List.of(79L, 14L, 55L, 13L));
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 50L, 98L, 2L);
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 52L, 50L, 48L);
    Assertions.assertEquals(14L, almanac.getSoilForSeed(14L));
  }

  @Test
  void seed_55_maps_to_soil_57() {
    Almanac almanac = new Almanac();
    almanac.seeds.addAll(List.of(79L, 14L, 55L, 13L));
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 50L, 98L, 2L);
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 52L, 50L, 48L);
    Assertions.assertEquals(57L, almanac.getSoilForSeed(55L));
  }

  @Test
  void seed_13_maps_to_soil_13() {
    Almanac almanac = new Almanac();
    almanac.seeds.addAll(List.of(79L, 14L, 55L, 13L));
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 50L, 98L, 2L);
    almanac.loadRangeAdjustmentMap(almanac.soilRangeAdjustmentMap, 52L, 50L, 48L);
    Assertions.assertEquals(13L, almanac.getSoilForSeed(13L));
  }

  @Test
  void seeds_from_test_file_are_79_14_55_13() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(List.of(79L, 14L, 55L, 13L), almanac.seeds);
  }

  @Test
  void seed_to_soil_mapping_from_file_are_81_14_57_13() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(81L, almanac.getSoilForSeed(79L));
    Assertions.assertEquals(14L, almanac.getSoilForSeed(14L));
    Assertions.assertEquals(57L, almanac.getSoilForSeed(55L));
    Assertions.assertEquals(13L, almanac.getSoilForSeed(13L));
  }

  @Test
  void soil_to_fertilizer_mapping_from_file_are_81_53_57_52() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(81L, almanac.getFertilizerForSoil(81L));
    Assertions.assertEquals(53L, almanac.getFertilizerForSoil(14L));
    Assertions.assertEquals(57L, almanac.getFertilizerForSoil(57L));
    Assertions.assertEquals(52L, almanac.getFertilizerForSoil(13L));
  }

  @Test
  void fertilizer_to_water_mapping_from_file_are_81_49_53_41() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(81L, almanac.getWaterForFertilizer(81L));
    Assertions.assertEquals(49L, almanac.getWaterForFertilizer(53L));
    Assertions.assertEquals(53L, almanac.getWaterForFertilizer(57L));
    Assertions.assertEquals(41L, almanac.getWaterForFertilizer(52L));
  }

  @Test
  void water_to_light_mapping_from_file_are_74_42_46_34() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(74L, almanac.getLightForWater(81L));
    Assertions.assertEquals(42L, almanac.getLightForWater(49L));
    Assertions.assertEquals(46L, almanac.getLightForWater(53L));
    Assertions.assertEquals(34L, almanac.getLightForWater(41L));
  }

  @Test
  void light_to_temperature_mapping_from_file_are_78_42_82_34() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(78L, almanac.getTemperatureForLight(74L));
    Assertions.assertEquals(42L, almanac.getTemperatureForLight(42L));
    Assertions.assertEquals(82L, almanac.getTemperatureForLight(46L));
    Assertions.assertEquals(34L, almanac.getTemperatureForLight(34L));
  }

  @Test
  void temperature_to_humidity_mapping_from_file_are_78_43_82_35() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(78L, almanac.getHumidityForTemperature(78L));
    Assertions.assertEquals(43L, almanac.getHumidityForTemperature(42L));
    Assertions.assertEquals(82L, almanac.getHumidityForTemperature(82L));
    Assertions.assertEquals(35L, almanac.getHumidityForTemperature(34L));
  }

  @Test
  void location_to_humidity_mapping_from_file_are_82_43_86_35() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(82L, almanac.getLocationForHumidity(78L));
    Assertions.assertEquals(43L, almanac.getLocationForHumidity(43L));
    Assertions.assertEquals(86L, almanac.getLocationForHumidity(82L));
    Assertions.assertEquals(35L, almanac.getLocationForHumidity(35L));
  }

  @Test
  void seed_to_location_mapping_from_file_are_82_43_86_35() throws Exception {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(82L, almanac.getLocationForSeed(79L));
    Assertions.assertEquals(43L, almanac.getLocationForSeed(14L));
    Assertions.assertEquals(86L, almanac.getLocationForSeed(55L));
    Assertions.assertEquals(35L, almanac.getLocationForSeed(13L));
  }

  @Test
  void closest_seed_location_from_file_is_35() throws FileNotFoundException {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(35L, almanac.getClosestLocation());
  }

  @Test
  void seeds_in_ranges_79_14_55_12() {
    Almanac almanac = new Almanac();
    almanac.addSeeds("79 14 55 13");
    Assertions.assertEquals(79L, almanac.seedsInRange.get(0));
    Assertions.assertEquals(92L, almanac.seedsInRange.get(13));
    Assertions.assertEquals(55L, almanac.seedsInRange.get(14));
    Assertions.assertEquals(67L, almanac.seedsInRange.get(26));
  }

  @Test
  void closest_see_in_range_location_from_file_is_46() throws FileNotFoundException {
    Almanac almanac = new Almanac("test.input");
    Assertions.assertEquals(46L, almanac.getClosestLocationInSeedRange());
  }
}
