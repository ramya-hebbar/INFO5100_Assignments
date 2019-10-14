public class Question4 {


    public void fillArrayWithValues() {
        int[] a = new int[5];

        for (int i = 0; i <= a.length; i++) {
            if(i == 5) {
                MyIndexOutOfBoundException mioobe = new MyIndexOutOfBoundException();
                mioobe.currentIndex = i;
                mioobe.lowerBoundValue = 0;
                mioobe.upperBoundValue = a.length-1;

                throw mioobe;
            }

            a[i] = i;
        }
    }

    public static void main(String[] args) {
        Question4 q4 = new Question4();

        try {
            q4.fillArrayWithValues();
        } catch (MyIndexOutOfBoundException mioobe) {
            System.out.println("Error Message: Index: " + mioobe.currentIndex +
                    ", but Lower bound: " + mioobe.lowerBoundValue + ", Upper bound: " + mioobe.upperBoundValue);

        }
    }
}

class MyIndexOutOfBoundException extends IndexOutOfBoundsException {
    int lowerBoundValue;
    int upperBoundValue;
    int currentIndex;
}