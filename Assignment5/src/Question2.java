class NumeratorIsZeroException extends RuntimeException {

}

class DenominatorIsZeroException extends RuntimeException {

}

class BothInputsAreZeroException extends RuntimeException {

}

class Number {
    public void count() {
        int a = Util.getRandomNumber(5);
        int b = Util.getRandomNumber(5);

        System.out.println("Value of a = " + a + " and b = " + b);

        if(a == 0 && b == 0) {
            throw new BothInputsAreZeroException();
        }

        if(a == 0) {
            throw new NumeratorIsZeroException();
        }

        if(b == 0) {
            throw new DenominatorIsZeroException();
        }

        System.out.println("Quotient of " + a + " and " + b + " is " + a/b);
    }

    private static void calculateQuotient(Number n) {
        try {
            n.count();
        }
        catch (BothInputsAreZeroException biaze) {
            System.out.println("Both inputs cannot be 0!");
        }
        catch (NumeratorIsZeroException nize) {
            System.out.println("Numerator value cannot be 0!");
        }
        catch (DenominatorIsZeroException dize) {
            System.out.println("Denominator value cannot be 0!");
        }
    }

    public static void main(String[] args) {
        Number n1 = new Number();
        calculateQuotient(n1);

        Number n2 = new Number();
        calculateQuotient(n2);

        Number n3 = new Number();
        calculateQuotient(n3);

        Number n4 = new Number();
        calculateQuotient(n4);

        Number n5 = new Number();
        calculateQuotient(n5);

        System.out.println("Done with quotients for the day!!");
    }
}

class Util {
    static int getRandomNumber(int x) {
        return (int) (Math.random() * x);
    }
}