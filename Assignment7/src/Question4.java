import java.util.Arrays;

public class Question4 {
    private long finalSum = 0;

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Util.getRandomNumber(100);
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr) {
        int finalSum = 0;

        for (int i = 0; i < arr.length; i++) {

            finalSum += arr[i];
        }

        return finalSum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[4000000];
        generateRandomArray(arr);

        sumTheValuesInParallelForArray(arr);
    }

    private static void sumTheValuesInParallelForArray(int[] arr) throws InterruptedException {

        int arraySplitter = arr.length / 4;

        SummingThread thread1 = new SummingThread(arr, 0, arraySplitter);
        SummingThread thread2 = new SummingThread(arr, arraySplitter + 1, arraySplitter * 2);
        SummingThread thread3 = new SummingThread(arr, (arraySplitter * 2) + 1, arraySplitter * 3);
        SummingThread thread4 = new SummingThread(arr, (arraySplitter * 3) + 1, arr.length);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }

    static class SummingThread extends Thread {
        private int[] arr;
        private int startIndex;
        private int endIndex;

        public SummingThread(int[] arr, int startIndex, int endIndex) {
            this.arr = arr;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            Question4 q4 = new Question4();
            q4.sumTheValues(Arrays.copyOfRange(this.arr, this.startIndex, this.endIndex));
        }
    }

    public synchronized void sumTheValues(int[] arr) {
        finalSum += sum(arr);
        System.out.println("Sum is : " + finalSum);
    }
}

class Util {
    static int getRandomNumber(int x) {
        return (int) (Math.random() * x);
    }
}


