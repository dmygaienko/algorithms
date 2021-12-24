package com.mygaienko.common.algorithms.leetcode.optimal_account_balancing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    AtomicInteger minTransfers = new AtomicInteger(0);

    public int minTransfers(int[][] transactions) {
        minTransfers.set(transactions.length);

        Map<Integer, Transactions> trans = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            int[] nextTran = transactions[i];
            int from = nextTran[0];
            int to = nextTran[1];
            int value = nextTran[2];

            addNewTransaction(trans, from, to, value);
        }

        for (Map.Entry<Integer, Transactions> entry : trans.entrySet()) {
            Transactions personTransactions = entry.getValue();
            Map<Integer, List<Integer>> inputs = personTransactions.getInputs();

            for (Map.Entry<Integer, List<Integer>> fromInputs : inputs.entrySet()) {
                Integer from = fromInputs.getKey();
                for (Integer amount : fromInputs.getValue()) {
                    if (existsInOutPuts(personTransactions, amount, trans, from)) {
                        minTransfers.decrementAndGet();
                    }
                }
            }
        }

        return minTransfers.get();
    }

    private boolean existsInOutPuts(Transactions personTransactions, Integer amount, Map<Integer, Transactions> trans, int newFrom) {
        Map<Integer, List<Integer>> outputs = personTransactions.getOutputs();
        List<Integer> integers = outputs.get(amount);
        if (integers != null && !integers.isEmpty()) {
            Integer to = integers.iterator().next();
            deleteTransaction(trans, newFrom, personTransactions.getPerson(), amount);
            deleteTransaction(trans, personTransactions.getPerson(), to, amount);
            addNewTransaction(trans, newFrom, to, amount);
            return true;
        }
        return false;
    }

    private void deleteTransaction(Map<Integer, Transactions> trans, Integer from, Integer to, Integer amount) {
        deleteOutput(trans, from, to, amount);
        deleteInput(trans, from, to, amount);
    }

    private void deleteInput(Map<Integer, Transactions> trans, Integer from, Integer to, Integer amount) {
        Transactions toTran = trans.get(to);
        toTran.getInputs().get(from).remove(amount);
    }

    private void deleteOutput(Map<Integer, Transactions> trans, Integer from, Integer to, Integer amount) {
        Transactions fromTran = trans.get(from);
        fromTran.getOutputs().get(amount).remove(to);
    }

    private void addNewTransaction(Map<Integer, Transactions> trans, int from, Integer to, Integer value) {
        addOutput(trans, from, to, value);
        addInput(trans, from, to, value);
        simplify(trans, from);
        simplify(trans, to);
    }

    private void simplify(Map<Integer, Transactions> trans, Integer person) {
        Transactions transactions = trans.get(person);
        for (Map.Entry<Integer, List<Integer>> entry : transactions.getOutputs().entrySet()) {
            for (Integer to : entry.getValue()) {
                List<Integer> inputsTo = transactions.getInputs().get(to);
                if (inputsTo != null && !inputsTo.isEmpty()) {
                    Integer in = inputsTo.stream()
                            .peek(v -> minTransfers.decrementAndGet())
                            .reduce(0, Integer::sum);
                    inputsTo.forEach(v -> deleteTransaction(trans, to, person, v));
                    Integer out = entry.getKey();

                    if (in > out) {
                        addNewTransaction(trans, to, person, in - out);
                    } else {
                        addNewTransaction(trans, person, to,out - in);
                    }

                    minTransfers.incrementAndGet();
                }
            }
        }

    }

    private void addOutput(Map<Integer, Transactions> t, int from, int to, int value) {
        t.putIfAbsent(from, new Transactions(from));
        Transactions transactions = t.get(from);
        Map<Integer, List<Integer>> outputs = transactions.getOutputs();
        outputs.putIfAbsent(value, new LinkedList<>());
        outputs.get(value).add(to);
    }

    private void addInput(Map<Integer, Transactions> t, int from, int to, int value) {
        t.putIfAbsent(to, new Transactions(to));
        Transactions transactions = t.get(to);
        Map<Integer, List<Integer>> inputs = transactions.getInputs();
        inputs.putIfAbsent(from, new LinkedList<>());
        List<Integer> integers = inputs.get(from);
        if (integers.size() == 0) {
            integers.add(value);
        } else {
            minTransfers.accumulateAndGet(integers.size(), (a, b) -> a-b);
            Integer sum = integers.stream().reduce(Integer::sum).orElse(0);
            deleteOutputs(t, from, to, integers);
            inputs.put(from, new LinkedList<>());
            addNewTransaction(t, from, to, sum + value);
        }
    }

    private void deleteOutputs(Map<Integer, Transactions> t, Integer from, Integer to, List<Integer> integers) {
        Transactions transactions = t.get(from);
        Map<Integer, List<Integer>> outputs = transactions.getOutputs();
        for (Integer integer : integers) {
            outputs.get(integer).remove(to);
        }
    }

    static class Transactions {
        int person;

        Map<Integer, List<Integer>> inputs = new HashMap<>(); //from -> value
        Map<Integer, List<Integer>> outputs = new HashMap<>(); //value -> to

        public Transactions(int person) {
            this.person = person;
        }

        public Map<Integer, List<Integer>> getInputs() {
            return inputs;
        }

        public Map<Integer, List<Integer>> getOutputs() {
            return outputs;
        }

        public int getPerson() {
            return person;
        }
    }

}
