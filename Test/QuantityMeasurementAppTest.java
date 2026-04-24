import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = a.add(b, Length.LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = a.add(b, Length.LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = a.add(b, Length.LengthUnit.YARDS);

        assertEquals(0.666666, result.getValue(), 0.01);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {

        Length a = new Length(1.0, Length.LengthUnit.INCHES);
        Length b = new Length(1.0, Length.LengthUnit.INCHES);

        Length result = a.add(b, Length.LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), 0.01);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length r1 = a.add(b, Length.LengthUnit.YARDS);
        Length r2 = b.add(a, Length.LengthUnit.YARDS);

        assertEquals(r1.getValue(), r2.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_WithZero() {

        Length a = new Length(5.0, Length.LengthUnit.FEET);
        Length b = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = a.add(b, Length.LengthUnit.YARDS);

        assertEquals(1.6666, result.getValue(), 0.01);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NegativeValues() {

        Length a = new Length(5.0, Length.LengthUnit.FEET);
        Length b = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = a.add(b, Length.LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> {
            a.add(b, null);
        });
    }
}