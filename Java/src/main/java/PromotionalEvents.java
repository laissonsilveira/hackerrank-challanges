import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Laisson R. Silveira
 * laisson.r.silveira@gmail.com
 * 2019-05-17
 **/
class PromotionalEvents {

    static Integer maxEvents(List<Integer> arrival, List<Integer> duration) {
        final int sizeArrival = arrival.size();
        final AtomicInteger max = new AtomicInteger(sizeArrival);

        IntStream.range(0, sizeArrival)
                .forEach(idx -> {
                    int a = arrival.get(idx);
                    int d = duration.get(idx);
                    int nextA = arrival.stream().filter(i -> i > a).findFirst().orElse(-1);

                    int conflict = Math.toIntExact(arrival.stream().filter(i -> a > -1 && i == a).count());
                    if (a > -1) {
                        if (conflict > 1) {
                            int[] matchingIndices = IntStream.range(0, arrival.size())
                                    .filter(i -> a == arrival.get(i)).toArray();
                            boolean isResolved = false;
                            for (int i : matchingIndices) {
                                if (!isResolved && arrival.get(i) + duration.get(i) <= nextA) {
                                    isResolved = true;
                                } else {
                                    max.getAndDecrement();
                                }
                                arrival.set(i, -1);
                                duration.set(i, -1);
                            }
                        } else if (idx + 1 != sizeArrival && nextA > -1) {
                            if ((a + d) > nextA) {
                                max.getAndDecrement();
                                arrival.set(idx, -1);
                                duration.set(idx, -1);
                            }
                        }
                    }
                });
        return max.get();
    }

}