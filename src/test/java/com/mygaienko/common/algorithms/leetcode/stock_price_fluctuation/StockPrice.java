package com.mygaienko.common.algorithms.leetcode.stock_price_fluctuation;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class StockPrice {

    TreeSet<TimePrice> treeSet = new TreeSet<>(Comparator.comparingInt(TimePrice::getPrice)
            .thenComparing(Comparator.comparingInt(TimePrice::getTimestamp)));
    Map<Integer, TimePrice> map = new HashMap<>();

    int latestTimestamp = Integer.MIN_VALUE;

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            TimePrice timePrice = map.get(timestamp);
            treeSet.remove(timePrice);

            timePrice.price = price;

            treeSet.add(timePrice);
        } else {
            TimePrice timePrice = new TimePrice(timestamp, price);
            treeSet.add(timePrice);
            map.put(timestamp, timePrice);
            latestTimestamp = Math.max(latestTimestamp, timestamp);
        }
    }

    public int current() {
        return map.get(latestTimestamp).price;
    }

    public int maximum() {
        return treeSet.last().price;
    }

    public int minimum() {
        return treeSet.first().price;
    }

}

class TimePrice {
    int timestamp;
    int price;

    public TimePrice(int timestamp, int price) {
        this.timestamp = timestamp;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getTimestamp() {
        return timestamp;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
