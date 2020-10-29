class Task1 {
    public static void main(String[] args) {
        System.out.println("Матрица 1:");
        int r = (int)(Math.random() * 5 + 2);
        int c = (int)(Math.random() * 5 + 2);
        int[][] m = new int[r][c];
        for (int[] arr : m) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 9 + 1);
            }
        }
        Matrix matrix1 = new Matrix(m);
        matrix1.print_matrix();

        System.out.println("Матрица 2:");
        int[][] n = new int[r][c]; // Одинаковые строки и колонки для более простого сложения и вычитания
        for (int[] arr : n) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 9 + 1);
            }
        }
        Matrix matrix2 = new Matrix(n);
        matrix2.print_matrix();


        System.out.println("Сложение:");
        Matrix result1 = new Matrix(matrix1.add(matrix2.matrix));
        result1.print_matrix();

        System.out.println("Вычитание:");
        Matrix result2 = new Matrix(matrix1.subtract(matrix2.matrix));
        result2.print_matrix();

        System.out.println("Умножение на число первой матрицы:");
        Matrix result3 = new Matrix(matrix1.multiply((int)(Math.random() * 9 + 2)));
        result3.print_matrix();


        System.out.println("Умножение на число второй матрицы:");
        Matrix result4 = new Matrix(matrix2.multiply((int)(Math.random() * 9 + 2)));
        result4.print_matrix();

        System.out.println("Умножение матрицы на матрицу:");
        if (r == c){
            Matrix result5 = new Matrix(matrix1.multiply2(matrix2.matrix));
            result5.print_matrix();
        }
        else {
            System.out.println("Нельзя умножить эти матрицы!");
        }


        System.out.println("Транспонирование матрицы 1:");
        Matrix result6 = new Matrix(matrix1.transposition());
        result6.print_matrix();

        System.out.println("Транспонирование матрицы 2:");
        Matrix result7 = new Matrix(matrix2.transposition());
        result7.print_matrix();

        System.out.println("Возвдение в степень матрицы 1:");
        Matrix result8 = new Matrix(matrix1.elevate(2));
        result8.print_matrix();

        System.out.println("Возведение в степень матрицы 2:");
        Matrix result9 = new Matrix(matrix2.elevate(3));
        result9.print_matrix();

    }
}

class Matrix{

    int[][] matrix;
    int rows;
    int columns;

    Matrix(int[][] m){
        matrix = m;
        rows = matrix.length;
        columns = matrix[0].length;
    }

    void print_matrix() {
        StringBuilder string = new StringBuilder();

        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                string.append(this.matrix[i][j]).append(" ");
            }
            System.out.println(string);
            string = new StringBuilder();
        }
    }

    int[][] add(int[][] matrix2) {
        int[][] result = new int[this.rows][this.columns];
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                result[i][j] = matrix2[i][j] + this.matrix[i][j];
            }
        }
        return result;
    }

    int[][] subtract(int[][] matrix2) {
        int[][] result = new int[this.rows][this.columns];
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                result[i][j] = matrix2[i][j] - this.matrix[i][j];
            }
        }
        return result;
    }

    int[][] multiply (int num){

        int[][] result = new int[this.rows][this.columns];

        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                result[i][j] = num * this.matrix[i][j];
            }
        }
        return result;
    }

    int[][] multiply2 (int[][] matrix2){

        int[][] result = new int[this.rows][this.columns];

        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                for (int k = 0; k < this.columns; k++)
                    result[i][j] += this.matrix[i][k] * matrix2[k][j];
            }
        }
        return result;
    }

    int[][] transposition () {

        int[][] result = new int[this.columns][this.rows];

        for(int i = 0; i < this.columns; i++){
            for(int j = 0; j < this.rows; j++){
                result[i][j] = this.matrix[j][i];
            }
        }
        return result;
    }

    int[][] elevate (int num) {

        Matrix result = new Matrix(this.matrix);

        for(int i = 0; i < num; i++){
            result.matrix = result.multiply2(this.matrix);
        }
        return result.matrix;
    }
    
}
