import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToYard_SameValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(1.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        assertFalse(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(2.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(3.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        assertTrue(new Length(3.0, Length.LengthUnit.FEET)
                .equals(new Length(1.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_CentimeterToInches() {
        assertTrue(new Length(1.0, Length.LengthUnit.CENTIMETERS)
                .equals(new Length(0.393701, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_CentimeterToFeet_NotEqual() {
        assertFalse(new Length(1.0, Length.LengthUnit.CENTIMETERS)
                .equals(new Length(1.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testEquality_TransitiveProperty() {
        Length a = new Length(1.0, Length.LengthUnit.YARDS);
        Length b = new Length(3.0, Length.LengthUnit.FEET);
        Length c = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }

    @Test
    public void testEquality_SameReference() {
        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        assertTrue(l.equals(l));
    }

    @Test
    public void testEquality_NullComparison() {
        Length l = new Length(1.0, Length.LengthUnit.YARDS);
        assertFalse(l.equals(null));
    }

    @Test
    public void testEquality_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }

    @Test
    public void testComplex_AllUnits() {
        Length y = new Length(2.0, Length.LengthUnit.YARDS);
        Length f = new Length(6.0, Length.LengthUnit.FEET);
        Length i = new Length(72.0, Length.LengthUnit.INCHES);

        assertTrue(y.equals(f) && f.equals(i) && y.equals(i));
    }
}