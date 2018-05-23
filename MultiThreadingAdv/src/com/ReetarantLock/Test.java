package com.ReetarantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test
{
  static final int MAX_T = 2;
  public static void main(String[] args)
  {
    ReentrantLock rel = new ReentrantLock();
    ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
    Runnable w1 = new worker(rel, "Job1");
    Runnable w2 = new worker(rel, "Job2");
    Runnable w3 = new worker(rel, "Job3");
    Runnable w4 = new worker(rel, "Job4");
    pool.execute(w1);
    pool.execute(w2);
    pool.execute(w3);
    pool.execute(w4);
    pool.shutdown();
  }
}