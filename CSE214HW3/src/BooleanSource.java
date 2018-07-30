/**
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #3 for CSE 214, Summer 2018
 * Date:
 *    July 25th, 2018
 */

//Class was copied from lecture slides
public class BooleanSource {
    private double probability;

    /**
     * Constructs and instance of BooleanSource with a given event probability, p.
     * @param p - probability that a certain event has
     * @throws IllegalArgumentException
     * Throws this exception if the probability is not between 0.0 and 1.0 which is 0% and 100%
     */
    public BooleanSource(double p) throws IllegalArgumentException{
        if (p < 0.0 || p > 1.0)
            throw new IllegalArgumentException();
        probability = p;
    }

    /**
     *  Checks to see if the random event actually occurs by checking if a random number is less than the chance of probability
     * @return
     * Returns true if the random number is within the probability and false if it's not
     */
    public boolean requestArrived() {
        return (Math.random() < probability);
    }
}
