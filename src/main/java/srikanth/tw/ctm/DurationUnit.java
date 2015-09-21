package srikanth.tw.ctm;

public enum DurationUnit {
    MINUTES(1, "min"), LIGHTENING(5, "lightning");

    private int factor;
    private String stringRepresentation;

    private DurationUnit(int factor, String stringRepresentation) {
        this.factor = factor;
        this.stringRepresentation = stringRepresentation;
    }

    public int inMinutes(int duration) {
        return factor * duration;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
