package br.com.bmo.java8tips.collections;

import java.util.*;

public class Exercise {

    public Cache useCache() {
        Cache cache = new Cache();

        cache.search("www.facebook.com");
        cache.search("www.google.com");
        cache.search("www.amazon.com");
        cache.search("www.google.com");
        cache.search("www.facebook.com");
        cache.search("www.twitter.com");
        cache.search("www.globalsoftwaresuppot.com");
        cache.search("www.bbc.com");
        cache.search("www.cnn.com");
        cache.search("www.google.com");
        cache.search("www.amazon.com");
        cache.search("www.google.com");
        cache.search("www.facebook.com");

        // the cache remembers the recently visited URLs (in this case: facebook, google, amazon, cnn, bbc - 5 because the capacity of the cache is 5)


        cache.showCache();

        // I need it to be able to test wether your implmenetation works fine
        return cache;
    }
}

class Pair {

    // let's store the URL and a data associated with the URL (for example the content of the website)
    // we store these Pair objects in the cache
    // YOUR IMPLEMENTATION HERE !!!
    private String url;
    private String htmlContent;

    public Pair(String url, String htmlContent) {
        this.url = url;
        this.htmlContent = htmlContent;
    }

    public String getUrl() {
        return url;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(url, pair.url) && Objects.equals(htmlContent, pair.htmlContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, htmlContent);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "url='" + url + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                '}';
    }
}

class Cache {

    // we can store up to 5 items in the cache
    private static final int CAPACITY = 5;
    // let's use a list to store the items (URLs)
    private List<Pair> cache;

    // YOUR IMPLEMENTATION HERE !!!
    public Cache() {
        this.cache = new ArrayList<>(CAPACITY);
    }

    public void search(String url) {
        Pair pair = null;
        for (Pair p : cache) {
            if (p.getUrl().equals(url)) {
                pair = p;
            }
        }

        if (this.cache.size() == CAPACITY) {
            this.cache.remove(0);
        }

        if (pair == null) {
            pair = new Pair(url, "Random HTML content");
            this.cache.add(pair);
        }
    }

    // I need it to test your implementation
    public List<Pair> getCache() {
        return this.cache;
    }

    public void showCache() {
        for(Pair pair : cache)
            System.out.println(pair);
    }
}
