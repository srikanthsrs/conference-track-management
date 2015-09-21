package srikanth.tw.ctm;

public class Event {
    private String name;
    private int duration;
    private DurationUnit unit;

    public Event(String name, int duration, DurationUnit unit) {
        this.name = name;
        this.duration = duration;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return name + " - " + duration + " " + unit;
    }

    public int getDurationInMinutes() {
        return unit.inMinutes(duration);
    }

    public String getName() {
        return name;
    }
}
