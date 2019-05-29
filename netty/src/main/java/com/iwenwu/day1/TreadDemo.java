package com.iwenwu.day1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TreadDemo {
    /**
     * 1  singlethreadwebserver
     */
    public static void singlethreadwebserver() throws IOException {
        ServerSocket server = new ServerSocket(80);
        while (true){
            Socket socket = server.accept();
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket socket) {
        //TODO
        //handle the socket
    }

    /**
     * 2  threadpertaskwebserver
     */
    public static void threadpertaskwebserver() throws IOException {
        ServerSocket server = new ServerSocket(80);
        while(true){
            final Socket socket =  server.accept();
            Runnable task = new Runnable() {
                public void run(){
                    handleRequest(socket);
                }
            };
            new Thread(task).start();
        }
    }

    //注意多线程 的run方法中运行的代码必须是线程安全的
    //任务是一组逻辑工作单元,线程是使任务异步执行的机制
    /**
     * 3 TaskExcutionWebServer
     */
    private static final int NThreads = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NThreads);
    public static void taskExcutionWebServer()throws IOException {
        ServerSocket server = new ServerSocket(80);
        while (true) {
            final Socket socket = server.accept();
            Runnable task = new Runnable() {
                public void run() {
                    handleRequest(socket);
                }
            };
            exec.execute(task);
        }
    }
    interface ExecutorService extends  Executor{
        void shutdown();
        List<Runnable> shutdownNow();
        boolean isShutdown();
        boolean isTerminated();
        boolean awaitTermination(long timeout, TimeUnit unit)
                throws InterruptedException;
        //...其他用于任务提交的便利方法
    }




    //Timer类负责管理延迟任务以及周期任务,然而Timer存在一些缺陷,因此应该考虑使用ScheduledThreadPoolExecutor
    //来代替它
    //1,注意Timer在执行所有定时任务时只会创建一个线程
    //2,如果某个任务的执行时间过长,那么将破坏其他TimerTask的精确性
    //3,如果TimerTask抛出一个未检查的异常,Timer线程并不捕获异常,因此当TimerTask抛出未检查的异常时
    //将终止定时线程,这种情况下,Timer也不会恢复线程的执行,而是错误的认为整个Timer都被取消了,因此,已经被调度
    //的但尚未执行的TimerTask将不会再执行,新的任务也不能被调度(这个问题称为"线程泄露"Thread Leakage)
    public static void outOfTime(){
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
    }

    static class ThrowTask extends TimerTask{
        public void run(){
            throw new RuntimeException();
        }
    }

    //携带结果的任务Callable与Future
    
}
