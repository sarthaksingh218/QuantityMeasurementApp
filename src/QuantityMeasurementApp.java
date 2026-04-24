public class QuantityMeasurementApp {

    public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
        return w1.equals(w2);
    }

    public static Weight demonstrateWeightConversion(double value, WeightUnit from, WeightUnit to) {
        return new Weight(value, from).convertTo(to);
    }

    public static Weight demonstrateWeightAddition(double v1, WeightUnit u1,
                                                   double v2, WeightUnit u2) {

        Weight w1 = new Weight(v1, u1);
        Weight w2 = new Weight(v2, u2);

        return w1.add(w2);
    }

    public static void main(String[] args) {

        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

        System.out.println(demonstrateWeightEquality(w1, w2));

        Weight converted = demonstrateWeightConversion(2.0, WeightUnit.POUND, WeightUnit.KILOGRAM);
        System.out.println(converted);

        Weight sum = demonstrateWeightAddition(1.0, WeightUnit.KILOGRAM,
                1000.0, WeightUnit.GRAM);

        System.out.println(sum);
    }
}