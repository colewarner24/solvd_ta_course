package topic10;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class ConnectionPool {
    private static ConnectionPool instance;
    private LinkedBlockingQueue<Connection> pool;
    private int poolSize;

    public ConnectionPool(int size) {
        poolSize = size;
        pool = new LinkedBlockingQueue<>(poolSize);

        // Lazy initialization of connections in the pool
        for (int i = 1; i <= size; i++) {
            pool.offer(new Connection("Process: " + i));
        }
    }

    public Connection getConnection() throws InterruptedException {
        return pool.poll(10, TimeUnit.SECONDS);
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    public int getSize() {
        return poolSize;
    }
}
