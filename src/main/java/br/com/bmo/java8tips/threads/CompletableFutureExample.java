package br.com.bmo.java8tips.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            try {
                return getSpaceXLatestLunch();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, executorService);

        result.thenAccept(System.out::println)
                .exceptionally(throwable -> {
                    System.out.println(String.format("Error occurred: %s", throwable.getMessage()));
                    return null;
                });

        System.out.println("Exec other lines");
        executorService.shutdown();
    }

    private static String getSpaceXLatestLunch() throws IOException {
        URL url = new URL("https://api.spacexdata.com/v5/launches/latest");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        in.close();
        conn.disconnect();

        return content.toString();
    }
}
