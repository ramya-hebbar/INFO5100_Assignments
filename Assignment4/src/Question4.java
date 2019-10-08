public class Question4 {

    public void getProductOfMatrices(int[][] matrixA, int[][] matrixB) {

        int m = matrixA.length;
        int n = matrixB[0].length;

        System.out.println("Matrix A rows : " + matrixA.length + " and columns : " + matrixA[0].length);
        System.out.println("Matrix B rows : " + matrixB.length + " and columns : " + matrixB[0].length);

        int[][] finalMatrix = new int[m][n];

        int sum = 0;

        for (int i = 0; i < m; i++) { // rows
            System.out.println("i = " + i);

            for (int x = 0; x < n; x++) {

                System.out.println("x = " + x);

                for (int j = 0; j < n; j++) { // columns
                    System.out.println("j = " + j);

                    sum += matrixA[i][x] * matrixB[x][j];
                }

                System.out.println("Item at [" + i + "] and [" + x + "] is " + sum);
                finalMatrix[i][x] = sum;
                sum = 0;
            }
        }

        System.out.println("Final product matrix is : \n");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(finalMatrix[i][j] + "\t");
            }

            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Question4 q4 = new Question4();

        int[][] matrixA = {{1, 0, 0}, {-1, 0, 3}}; //2X3
        int[][] matrixB = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}}; //3X3

        q4.getProductOfMatrices(matrixA, matrixB);

    }
}
