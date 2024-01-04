package com.mygaienko.common.algorithms.leetcode.web_crawler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public static final Pattern PATTERN = Pattern.compile("^(http://[a-z0-9.]+)(/?.*)");

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        var host = getHost(startUrl);
        var visited = new HashSet<String>();
        crawl(host, startUrl, htmlParser, visited);
        return new ArrayList<>(visited);
    }

    public String getHost(String startUrl) {
        Matcher matcher = PATTERN.matcher(startUrl);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return "";
//        return startUrl.split("/")[2];
    }

    public void crawl(String host, String parentUrl, HtmlParser htmlParser, Set<String> visited) {
        for (var url : htmlParser.getUrls(parentUrl)) {
            if (url.startsWith(host) && !visited.contains(url)) {
                visited.add(url);
                crawl(host, url, htmlParser, visited);
            }
        }
    }

}

interface HtmlParser {

    List<String> getUrls(String url);

}
