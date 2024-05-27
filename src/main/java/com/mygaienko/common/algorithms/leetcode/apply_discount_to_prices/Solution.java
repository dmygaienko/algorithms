package com.mygaienko.common.algorithms.leetcode.apply_discount_to_prices;

class Solution {
    public String discountPrices(String sentence, int discount) {
        var sb = new StringBuilder();

        for (var token : sentence.split(" ")) {
            if (token.charAt(0) == '$' && token.length() > 1 && token.length() <= 11) {
                var price = 0L;
                for (int i = 1; i < token.length(); i++) {
                    var next = token.charAt(i);
                    if (Character.isDigit(next)) {
                        price = price * 10 + (next - '0');
                    } else {
                        sb.append(token);
                        sb.append(" ");
                        price = -1;
                        break;
                    }
                }
                if (price == -1) continue;

                sb.append("$");
                sb.append(calc(price, discount));
                sb.append(" ");
            } else {
                sb.append(token);
                sb.append(" ");
            }
        }

        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    String calc(long val, int discount) {
        var ans = val * (100 - discount) / 100d;
        return String.format("%.2f", ans);
    }
}