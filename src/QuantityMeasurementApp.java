public class QuantityMeasurementApp {

    public static double convert(double value, Length.LengthUnit source, Length.LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException();
        }

        if (source == target) {
            return value;
        }

        double baseValue = value * source.getFactor();
        return baseValue / target.getFactor();
    }

    public static Length add(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length add(double v1, Length.LengthUnit u1,
                             double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.add(l2);
    }

    public static void main(String[] args) {

        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = add(a, b);

        System.out.println(result);

        System.out.println(add(
                1.0,
                Length.LengthUnit.YARDS,
                3.0,
                Length.LengthUnit.FEET
        ));
    }
}