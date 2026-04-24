import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(2.0, Length.LengthUnit.FEET);

        Length result = a.add(b);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_SameUnit_InchPlusInch() {

        Length a = new Length(6.0, Length.LengthUnit.INCHES);
        Length b = new Length(6.0, Length.LengthUnit.INCHES);

        Length result = a.add(b);

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = a.add(b);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {

        Length a = new Length(12.0, Length.LengthUnit.INCHES);
        Length b = new Length(1.0, Length.LengthUnit.FEET);

        Length result = a.add(b);

        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_Commutativity() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result1 = a.add(b);
        Length result2 = b.add(a);

        assertEquals(result1.convertTo(Length.LengthUnit.INCHES).getValue(),
                result2.getValue(), EPSILON);
    }

    @Test
    void testAddition_WithZero() {

        Length a = new Length(5.0, Length.LengthUnit.FEET);
        Length b = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = a.add(b);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {

        Length a = new Length(5.0, Length.LengthUnit.FEET);
        Length b = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = a.add(b);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NullSecondOperand() {

        Length a = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            a.add(null);
        });
    }

    @Test
    void testAddition_LargeValues() {

        Length a = new Length(1e6, Length.LengthUnit.FEET);
        Length b = new Length(1e6, Length.LengthUnit.FEET);

        Length result = a.add(b);

        assertEquals(2e6, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_SmallValues() {

        Length a = new Length(0.001, Length.LengthUnit.FEET);
        Length b = new Length(0.002, Length.LengthUnit.FEET);

        Length result = a.add(b);

        assertEquals(0.003, result.getValue(), EPSILON);
    }
}