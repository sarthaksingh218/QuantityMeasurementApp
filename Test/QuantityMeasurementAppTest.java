import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementTest {

    @Test
    void testEquality_KilogramToKilogram_SameValue() {

        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1.0, WeightUnit.KILOGRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testEquality_KilogramToGram() {

        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testConversion_KilogramToGram() {

        Weight w = new Weight(1.0, WeightUnit.KILOGRAM);

        Weight result = w.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    @Test
    void testConversion_PoundToKilogram() {

        Weight w = new Weight(2.20462, WeightUnit.POUND);

        Weight result = w.convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), 0.01);
    }

    @Test
    void testAddition_KilogramPlusGram() {

        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

        Weight result = w1.add(w2);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    @Test
    void testAddition_ExplicitTargetUnit() {

        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

        Weight result = w1.add(w2, WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), 0.01);
    }

    @Test
    void testEquality_NullComparison() {

        Weight w = new Weight(1.0, WeightUnit.KILOGRAM);

        assertFalse(w.equals(null));
    }

    @Test
    void testZeroValueEquality() {

        Weight w1 = new Weight(0.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(0.0, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

}