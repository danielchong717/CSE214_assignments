package hw03;

import java.util.ArrayList;
/**
 * This hw03.RequestQueue class must be derived as a subclass of ArrayList (or other class) from the Java API.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class RequestQueue extends ArrayList {
    /**
     * A constructor for the class hw03.RequestQueue
     */
    public RequestQueue() {
        super();
    }

    /**
     * Adds object to the queue
     * @param request
     * Object hw03.Request to be added to
     */
    public void enqueue(Request request) {
        add(request);
    }
    /**
     * Removes object from the queue
     */
    public Request dequeue() {
        if (isEmpty()) {
            return null;
        }
        return (Request) remove(0);
    }
}
