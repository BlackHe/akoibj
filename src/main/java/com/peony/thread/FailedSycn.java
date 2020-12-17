package com.peony.thread;

import com.peony.log.Log;
import com.peony.utils.Sleeper;

import java.util.Random;
import java.util.Scanner;

/**
 * 有三个任务，只要其中一个失败，其他两个都取消
 */
public class FailedSycn {


    static volatile boolean runOfNormal = true;
    static int errorNumThresold = -1;
    final static int taskSum = 3;



    public static void main(String[] args) {

        Log.info("请输入一个整数");
        Scanner scanner = new Scanner(System.in);
        errorNumThresold = scanner.nextInt();
        Thread scanChain = new Thread(new Task("扫链", 1));
        Thread blockAnalysis = new Thread(new Task("区块分析", 2));
        Thread generalOrder = new Thread(new Task("生成订单", 3));
        scanChain.start();
        blockAnalysis.start();
        generalOrder.start();
        try{
            scanChain.join();
            blockAnalysis.join();
            generalOrder.join();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    static class Task implements Runnable{
        int taskId;
        String taskName;

        public Task(String taskName,int taskId) {
            this.taskName = taskName;
            this.taskId = taskId;
            Log.info("[%s]任务已初始化",taskName);
        }

        @Override
        public void run() {
            Log.info("[%s]任务启动",taskName);

            while (runOfNormal){
                Sleeper.sleep(new Random().nextInt(3));
                Log.info("[%s]任务正在执行任务",taskName);
                if (errorNumThresold > 0 && errorNumThresold % taskSum == taskId){
                    Log.info("[%s]任务出错，发出信号并安全退出",taskName);
                    runOfNormal = false;
                    return;
                }
            }
            Log.info("其他任务出错，[%s]任务安全退出",taskName);

        }
    }

}
