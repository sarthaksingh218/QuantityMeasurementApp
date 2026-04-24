public class QuantityMeasurementApp {

    public static double convert(double value, Length.LengthUnit source, Length.LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException();
        }

        double baseValue = value * source.getFactor();

        return baseValue / target.getFactor();
    }

    public static Length add(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length add(Length l1, Length l2, Length.LengthUnit targetUnit) {
        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println(add(a, b, Length.LengthUnit.FEET));
        System.out.println(add(a, b, Length.LengthUnit.INCHES));
        System.out.println(add(a, b, Length.LengthUnit.YARDS));

        Length c = new Length(36.0, Length.LengthUnit.INCHES);
        Length d = new Length(1.0, Length.LengthUnit.YARDS);

        System.out.println(add(c, d, Length.LengthUnit.FEET));
    }
}