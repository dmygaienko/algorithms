package com.mygaienko.common.algorithms.condingame.hard.super_computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAdder;

import static java.util.Comparator.comparing;

/**
 *
 * In the Computer2000 data center, you are responsible for planning the usage of a supercomputer for scientists. ​
 * Therefore you've decided to organize things a bit by planning everybody’s tasks.
 * The logic is simple: the higher the number of calculations which can be performed, the more people you can satisfy.
 *
 *  	Rules
 * Scientists give you the starting day of their calculation and the number of consecutive days they need to reserve the calculator.
 *
 * For example:
 * Calculation	Starting Day	Duration
 * A	2	5
 * B	9	7
 * C	15	6
 * D	9	3
 * Calculation A starts on day 2 and ends on day 6
 *
 * Calculation B starts on day 9 and ends on day 15
 *
 * Calculation starts on day 15 and ends on day 20
 *
 * Calculation D starts on day 9 and ends on day 11
 *
 * In this example, it’s not possible to carry out all the calculations because the periods for B and C overlap.
 * 3 calculations maximum can be carried out: A, D and C.
 *
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class ArraySolution {

    public static void main(String args[]) {
        System.err.println("running");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            requests.add(new Request(in.nextInt(), in.nextInt()));
        }
        requests.sort(comparing(Request::getStartDay).thenComparing(Request::getDuration));
        System.err.println(requests);

        Request request = requests.get(requests.size() - 1);
        Period period = findShortTimeRequest(requests, 0, 0, request.startDay + request.duration);

        System.out.println(period.quantity);
    }

    private static Period findShortTimeRequest(List<Request> requests, int i, int startDate,int endDate) {
        LongAdder quantity = new LongAdder();

        int nextOpenDay = startDate;

        for ( ; i < requests.size() && requests.get(i).startDay < endDate; i++) {
            Request request = requests.get(i);

            if (request.startDay >= nextOpenDay && request.getNextOpenDay() <= endDate) {

                nextOpenDay = request.getNextOpenDay();

                if (request.duration > 2) {
                    Period period = findShortTimeRequest(requests, i + 1, request.startDay + 1, nextOpenDay);
                    if (period.quantity > 1) {
                        nextOpenDay = period.endDay;
                        quantity.add(period.quantity);
                        i = period.requestOrder;
                        continue;
                    }

                }
                quantity.increment();
            }
        }

        return new Period(nextOpenDay, quantity.intValue(), i);
    }

    public static class Period {
        final int endDay;
        final int quantity;
        final int requestOrder;

        public Period(int endDay, int quantity, int requestOrder) {
            this.endDay = endDay;
            this.quantity = quantity;
            this.requestOrder = requestOrder;
        }

        public int getEndDay() {
            return endDay;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getRequestOrder() {
            return requestOrder;
        }
    }

    public static class Request {
        final int startDay;
        final int duration;

        public Request(int startDay, int duration) {
            this.startDay = startDay;
            this.duration = duration;
        }

        public int getStartDay() {
            return startDay;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "startDay=" + startDay +
                    ", duration=" + duration +
                    '}';
        }

        public int getNextOpenDay() {
            return startDay + duration;
        }
    }

}
