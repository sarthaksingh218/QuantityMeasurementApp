public class Weight {

    private final double value;
    private final WeightUnit unit;

    private static final double EPSILON = 1e-6;

    public Weight(double value, WeightUnit unit) {
        if (!Double.isFinite(value))
            throw new IllegalArgumentException();

        if (unit == null)
            throw new IllegalArgumentException();

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public Weight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException();

        if (targetUnit == this.unit)
            return this;

        double baseValue = toBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Weight(converted, targetUnit);
    }

    public Weight add(Weight other) {
        return add(other, this.unit);
    }

    public Weight add(Weight other, WeightUnit targetUnit) {

        if (other == null || targetUnit == null)
            throw new IllegalArgumentException();

        double base1 = this.toBaseUnit();
        double base2 = other.toBaseUnit();

        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Weight(result, targetUnit);
    }

    private boolean compare(Weight other) {
        double base1 = this.toBaseUnit();
        double base2 = other.toBaseUnit();
        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Weight))
            return false;

        Weight other = (Weight) obj;

        return compare(other);
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(toBaseUnit());
        return (int)(bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}