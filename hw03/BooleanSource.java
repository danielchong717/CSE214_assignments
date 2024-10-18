package hw03;

/**
 * This hw03.BooleanSource class implements a double named probability as a member variable, a constructor that accepts a double as a parameter as the value of this member variable, and also a boolean method called requestArrived() that returns true a percentage of the time equal to probability (and otherwise it returns false).
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class BooleanSource {
    private double probability;
    /**
     * A constructor that accepts a double as a parameter as the value of this member variable
     * @param probability
     * double value for the probability variable to be set to
     */
    public BooleanSource(double probability) {
        if (probability < 0.0 || probability > 1.0)
            throw new IllegalArgumentException();
        this.probability = probability;
    }
    /**
     * A boolean method called requestArrived() that returns true a percentage of the time equal to probability (and otherwise it returns false).
     * @return
     * A boolean value
     */
    public boolean requestArrived() {
        if (probability < 0.0 || probability > 1.0)
            throw new IllegalArgumentException();
        return (Math.random() < probability);
    }
}
