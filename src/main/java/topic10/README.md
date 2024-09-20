1. Create 2 Threads using Runnable and Thread.
2. Create a Connection Pool. Use collection from java.util.concurrent package. Connection class may be mocked. The pool should be
   threadsafe and lazy initialized.
3. Initialize pool with 5 sizes. Load Connection Pool using threads and Thread Pool(7 threads). 5 threads should be able to get the
   connection. 2 Threads should wait for the next available connection. The program should wait as well.
4. Implement 4th part but with IFuture and CompletableStage