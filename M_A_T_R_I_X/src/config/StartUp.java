package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author pvmeira
 */
public class StartUp {
    private static final String CC = "file/";
    private static final String PATH = "file02";
    private static final String EXT = ".txt";
    private int[][] matrixFinal;
    private int[][] matrixCopy01;
    private int[][] matrixCopy02;
    private int colum;
    private int line;

    /**
     * Method that Read the Document base on the PATH and EXT values
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readDocument() throws FileNotFoundException, IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(CC + PATH + EXT))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            boolean firsTime = false;
            int count = 0;
            this.createTheMatrixFromADocument(line);

            while (line != null) {

                if (firsTime) {
                    this.populateTheMatrix(line, count);
                    if (count < this.colum) {
                        count++;
                    }
                }

                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();

                firsTime = true;
            }
            this.matrixCopy01 = this.copyTheOriginalMatrix(this.matrixFinal);
            this.matrixCopy01 = swapNumbersOnMatrix(this.matrixCopy01,0);
            this.matrixCopy02 = this.copyTheOriginalMatrix(this.matrixFinal);
            this.matrixCopy02 = swapNumbersOnMatrix(this.matrixCopy02,1);

            System.out.println("-----------------------------------------");
            this.printMatrix(this.matrixFinal);
            System.out.println("-----------------------------------------");
            this.printMatrix(this.matrixCopy01);
            System.out.println("-----------------------------------------");
            this.printMatrix(this.matrixCopy02);
            System.out.println("-----------------------------------------");
        }
    }

    private int[][] swapNumbersOnMatrix(int[][] multi, int option) {
        if (option == 0) {
            for (int i = 0; i < multi.length; i++) {
                for (int j = 0; j < multi[i].length; j++) {
                    if(j == 0){
                        multi[i][j] = this.turnOnTwo(j);
                    }

                }
            }
        } else {
            if (option == 1) {
                for (int i = 0; i < multi.length; i++) {
                    for (int j = 0; j < multi[i].length; j++) {
                        if(j == 1){
                            multi[i][j] = this.turnOnTwo(j);
                        }
                    }
                }
            }
        }

        return multi;
    }

    public int[][] copyTheOriginalMatrix(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }


    /**
     * print the given matrix using | to split the colums
     *
     * @param matrix
     */

    public void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
                .forEach(
                        (row) -> {
                            System.out.print("|");
                            Arrays.stream(row)
                                    .forEach((el) -> System.out.print(" " + el + " "));
                            System.out.println("|");
                        }
                );
    }


    /**
     * Method that populate the matrix
     */
    private void populateTheMatrix(String line, int count) {
        char[] index = line.toCharArray();
        int[] intArray = new int[index.length];

        for (int i = 0; i < index.length; i++) {
            intArray[i] = getValueFromAChar(index, i);

        }

        for (int i = 0; i < this.colum; i++) {
            this.matrixFinal[count][i] = intArray[i];
        }

    }

    /**
     * Swap the values received to 2
     *
     * @param i
     * @return
     */
    private int turnOnTwo(int i) {
        i = 2;
        return i;
    }

    /**
     * Get the value from a position into the given array
     *
     * @param index
     * @param position
     * @return
     */
    private int getValueFromAChar(char[] index, int position) {
        int result = 0;
        result = Character.getNumericValue(index[position]);
        return result;
    }

    /**
     * get the values from the given lines and than send to the methos that
     * create the array[][]
     *
     * @param line
     */
    private void createTheMatrixFromADocument(String line) {
        char[] index = line.toCharArray();
        int colum = this.getValueFromAChar(index, 0);
        int lines = this.getValueFromAChar(index, 2);
        this.line = lines;
        this.colum = colum;

        this.matrixFinal = this.instantiateTheMatrix(colum, lines);
    }

    /**
     * Initiate the Array
     *
     * @return
     */
    private int[][] instantiateTheMatrix(int line, int colum) {
        int[][] result = new int[colum][line];
        return result;
    }

    /**
     * @return
     */
    public int[][] getMatrixFinal() {
        return matrixFinal;
    }

    /**
     * @param matrixFinal
     */
    public void setMatrixFinal(int[][] matrixFinal) {
        this.matrixFinal = matrixFinal;
    }

    /**
     * @return
     */
    public int getColum() {
        return colum;
    }

    /**
     * @param colum
     */
    public void setColum(int colum) {
        this.colum = colum;
    }

    /**
     * @return
     */
    public int getLine() {
        return line;
    }

    /**
     * @param line
     */
    public void setLine(int line) {
        this.line = line;
    }

    public int[][] getMatrixCopy01() {
        return matrixCopy01;
    }

    public void setMatrixCopy01(int[][] matrixCopy01) {
        this.matrixCopy01 = matrixCopy01;
    }

    public int[][] getMatrixCopy02() {
        return matrixCopy02;
    }

    public void setMatrixCopy02(int[][] matrixCopy02) {
        this.matrixCopy02 = matrixCopy02;
    }
}
