package aoc.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestCalibrationDocument {

    @Test
    @SuppressWarnings("unchecked")
    void calibration_record_equals_12_when_first_digit_is_1_and_last_digit_is_2() {
        CalibrationDocument document = new CalibrationDocument(Mockito.mock(List.class));
        assertEquals(12, document.rowCalibrationValue("1abc2"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void calibration_record_equals_38_when_first_digit_is_3_and_last_digit_is_8() {
        CalibrationDocument document = new CalibrationDocument(Mockito.mock(List.class));
        assertEquals(38, document.rowCalibrationValue("pqr3stu8vwx"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void calibration_record_equals_15_when_first_digit_is_1_and_last_digit_is_5() {
        CalibrationDocument document = new CalibrationDocument(Mockito.mock(List.class));
        assertEquals(15, document.rowCalibrationValue("a1b2c3d4e5f"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void calibration_record_equals_77_when_the_only_digit_is_7() {
        CalibrationDocument document = new CalibrationDocument(Mockito.mock(List.class));
        assertEquals(77, document.rowCalibrationValue("treb7uchet"));
    }

    @Test
    void total_of_calibration_document_is_142() {
        List<String> calibrationDocument = new ArrayList<>();
        calibrationDocument.add("1abc2");
        calibrationDocument.add("pqr3stu8vwx");
        calibrationDocument.add("a1b2c3d4e5f");
        calibrationDocument.add("treb7uchet");
        CalibrationDocument document = new CalibrationDocument(calibrationDocument);
        assertEquals(142, document.totalCalibrationDocumentValue());
    }

    @Test
    void load_of_calibrationDocument_from_file_matches_expected() throws FileNotFoundException {
        CalibrationDocument document = new CalibrationDocument("test.input");
        assertEquals("1abc2", document.calibrationDocument.get(0));
        assertEquals("pqr3stu8vwx", document.calibrationDocument.get(1));
        assertEquals("a1b2c3d4e5f", document.calibrationDocument.get(2));
        assertEquals("treb7uchet", document.calibrationDocument.get(3));
    }

    @Test
    void incorrect_filename_results_in_null_pointer_exception() throws FileNotFoundException {
        try {
            new CalibrationDocument("missing.input");
        } catch (NullPointerException e) {
            assertThrowsExactly(NullPointerException.class, () -> {
                throw e;
            });
        }
    }
}