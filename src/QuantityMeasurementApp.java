public class QuantityMeasurementApp {

    public static double convert(double value, Length.LengthUnit source, Length.LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        if (source == target) {
            return value;
        }

        double baseValue = value * source.getFactor();
        double convertedValue = baseValue / target.getFactor();

        return convertedValue;
    }

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(double value,
                                                     Length.LengthUnit from,
                                                     Length.LengthUnit to) {

        Length length = new Length(value, from);
        return length.convertTo(to);
    }

    public static Length demonstrateLengthConversion(Length length,
                                                     Length.LengthUnit to) {

        return length.convertTo(to);
    }

    public static void main(String[] args) {

        System.out.println(convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
        System.out.println(convert(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET));
        System.out.println(convert(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS));
        System.out.println(convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES));
        System.out.println(convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));

        Length l1 = new Length(3.0, Length.LengthUnit.FEET);
        Length l2 = new Length(36.0, Length.LengthUnit.INCHES);

        System.out.println(demonstrateLengthEquality(l1, l2));

        Length converted = demonstrateLengthConversion(2.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES);

        System.out.println(converted);
    }
}