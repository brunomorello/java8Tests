package br.com.bmo.java8tips.interviews;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NonOverlappingEvents {
    public static int maxTwoEvents(int[][] events) {
//        Arrays.sort(events , (a,b)-> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
//        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//
//        int max = 0, ans = 0;
//        pq.add(new int[]{events[0][1] , events[0][2]});
//
//        for(int i=1 ; i<events.length ; i++)
//        {
//            while(!pq.isEmpty() && pq.peek()[0]<events[i][0])
//            {
//                int a[] = pq.poll();
//                max = Math.max(max , a[1]);
//            }
//            ans = Math.max(ans , max + events[i][2]);
//            pq.add(new int[]{events[i][1] , events[i][2]});
//        }
//        while(!pq.isEmpty())
//        {
//            ans = Math.max(ans , pq.poll()[1]);
//        }
//
//        return ans;
        Arrays.sort(events, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        Integer maxEnd = Stream.of(events)
                .map(ints -> ints[1])
                .max(Integer::compareTo)
                .orElse(0);
        List<Integer> shedule = new ArrayList<>(maxEnd);
        List<int[]> eventsList = new ArrayList<>();

        for (int i = 0; i < events.length; i++) {
            if (shedule.isEmpty()) {
                for (int j = events[i][0]-1; j < events[i][1]; j++) {
                    shedule.add(j, events[i][2]);
                }
                eventsList.add(events[i]);
            }

            if ((events[i][0]) > shedule.size()) {
                for (int j = events[i][0]-1; j < events[i][1]; j++) {
                    shedule.add(j, events[i][2]);
                }
                eventsList.add(events[i]);
            }
        }

        return eventsList.stream()
                .map(ints -> ints[2])
                .reduce(0, (i1, i2) -> i1 + i2);
    }
}
