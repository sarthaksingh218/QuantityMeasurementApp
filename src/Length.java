public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    public enum LengthUnit {
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return value * unit.getFactor();
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        if (this.unit == targetUnit) {
            return this;
        }

        double baseValue = toBaseUnit();
        double convertedValue = baseValue / targetUnit.getFactor();

        return new Length(convertedValue, targetUnit);
    }

    private boolean compare(Length other) {
        double thisBase = this.toBaseUnit();
        double otherBase = other.toBaseUnit();
        return Math.abs(thisBase - otherBase) < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;
        return compare(other);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}