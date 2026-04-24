public class QuantityMeasurementApp {

    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException();
        }

        double baseValue = source.convertToBaseUnit(value);

        return target.convertFromBaseUnit(baseValue);
    }

    public static Length add(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length add(Length l1, Length l2, LengthUnit targetUnit) {
        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(12.0, LengthUnit.INCHES);

        System.out.println(add(a, b, LengthUnit.FEET));
        System.out.println(add(a, b, LengthUnit.INCHES));
        System.out.println(add(a, b, LengthUnit.YARDS));

        Length c = new Length(36.0, LengthUnit.INCHES);
        Length d = new Length(1.0, LengthUnit.YARDS);

        System.out.println(add(c, d, LengthUnit.FEET));
    }
}