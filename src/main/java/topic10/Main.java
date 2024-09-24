package topic10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Main {

    private static final int SLEEP_TIME = 4000;

    public static void main(String[] args) {
        runPool(5, 7);
        runPoolStages(5, 7);
    }

    public static void runPool(int poolSize, int threads) {
        ConnectionPool pool = new ConnectionPool(poolSize);

        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                try {
                    Connection connection = pool.getConnection();
                    if (connection != null) {
                        System.out.println(connection.getName() + " connected");
                        Thread.sleep(SLEEP_TIME);
                        pool.releaseConnection(connection);
                    } else {
                        System.out.println("Thread: " + Thread.currentThread().getName() + " couldn't connect");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    public static void runPoolStages(int poolSize, int threads) {
        ConnectionPool pool = new ConnectionPool(poolSize);

        for (int i = 0; i < threads; i++) {
            CompletionStage<Connection> connectionStage = CompletableFuture.supplyAsync(() -> {
                try {
                    Connection connection = pool.getConnection();
                    if (connection != null) {
                        System.out.println("Thread: " + connection.getName() + " connected");
                        return connection;
                    } else {
                        System.out.println("Thread: " + Thread.currentThread().getName() + " couldn't connect");
                        return null;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            });

            connectionStage.thenCompose(connection -> {
                return CompletableFuture.runAsync(() -> {
                    if (connection != null) {
                        try {
                            Thread.sleep(SLEEP_TIME);
                            pool.releaseConnection(connection);
                            System.out.println("Thread: " + connection.getName() + " released connection");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            });
        }
    }
}
