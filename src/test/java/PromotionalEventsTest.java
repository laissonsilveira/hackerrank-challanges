import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Laisson R. Silveira
 * laisson.r.silveira@gmail.com
 * 2019-05-17
 **/
public class PromotionalEventsTest {

    @Test
    public void test01() {
        List<Integer> arrival = new LinkedList<>(Arrays.asList(1, 3, 3, 5, 7));
        List<Integer> duration = new LinkedList<>(Arrays.asList(2, 2, 1, 2, 1));
        Assert.assertEquals(new Integer(4), PromotionalEvents.maxEvents(arrival, duration));
    }

    @Test
    public void test02() {
        List<Integer> arrival = new LinkedList<>(Arrays.asList(1, 3, 5));
        List<Integer> duration = new LinkedList<>(Arrays.asList(2, 2, 2));
        Assert.assertEquals(new Integer(3), PromotionalEvents.maxEvents(arrival, duration));
    }

    @Test
    public void test03() {
        List<Integer> arrival = new LinkedList<>(Collections.singletonList(1));
        List<Integer> duration = new LinkedList<>(Collections.singletonList(5));
        Assert.assertEquals(new Integer(1), PromotionalEvents.maxEvents(arrival, duration));
    }

    @Test
    public void test04() {
        List<Integer> arrival = new LinkedList<>(Arrays.asList(1, 1, 1, 1, 4));
        List<Integer> duration = new LinkedList<>(Arrays.asList(10, 3, 6, 4, 2));
        Assert.assertEquals(new Integer(2), PromotionalEvents.maxEvents(arrival, duration));
    }

}
