public class Question4 {
    private static Object ANSWER_LOCK = new Object();

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Util.getRandomNumber(100);
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        int finalSum = 0;

        String string = new String();

        for (int i = 0; i < arr.length; i++) {

            if(i == 0) {
                string = "Sum of " + arr[i];
            }
            else {
                string = string + " + " + arr[i];
            }

            finalSum += arr[i];
        }

        string = string + " is " + finalSum;

        System.out.println(string);

        return finalSum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[40000];
        generateRandomArray(arr);

        sumTheValuesInParallelForArray(arr);

//        long sum = sum(arr);
//        System.out.println("Sum: " + sum);
    }

    private static void sumTheValuesInParallelForArray(int[] arr) throws InterruptedException{

        SummingThread thread1 = new SummingThread(arr);
        SummingThread thread2 = new SummingThread(arr);
        SummingThread thread3 = new SummingThread(arr);
        SummingThread thread4 = new SummingThread(arr);

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

        public SummingThread(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            Question4 q4 = new Question4();
            long sum = q4.sumTheValues(this.arr);
            System.out.println("Sum is : " + sum);
        }
    }

    public synchronized long sumTheValues(int[] arr) {
        synchronized (ANSWER_LOCK) {
            return sum(arr);
        }
    }
}

class Util {
    static int getRandomNumber(int x) {
        return (int) (Math.random() * x);
    }
}


