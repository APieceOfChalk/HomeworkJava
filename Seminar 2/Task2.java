public class Task2 {
    
    public static void main(String[] args){

        System.out.println("Вектор 1:");
        Vector vector1 = new Vector(Math.random() * 9 + 1, Math.random() * 9 + 1, Math.random() * 9 + 1);
        vector1.print_vector();

        System.out.println("Вектор 2:");
        Vector vector2 = new Vector(Math.random() * 9 + 1, Math.random() * 9 + 1, Math.random() * 9 + 1);
        vector2.print_vector();

        System.out.println("Длина вектора 1:");
        System.out.println(vector1.length());

        System.out.println("Длина вектора 2:");
        System.out.println(vector2.length());

        System.out.println("Скалярное произведение:");
        System.out.println(vector1.scalar(vector2));

        System.out.println("Векторное произведение:");
        vector1.vector_multiply(vector2).print_vector();

        System.out.println("Угол между векторами:");
        System.out.println(vector1.angle(vector2));

        System.out.println("Сложение векторов:");
        vector1.addition(vector2).print_vector();

        System.out.println("Вычитание векторов:");
        vector1.subtraction(vector2).print_vector();

        }

    }

}

class Vector{

    int x;
    int y;
    int z;

    Vector(int x, int y, int z){

        this.x = x;
        this.y = y;
        this.z = z;

    }

    void print_vector(){

        System.out.println("(" + this.x + "; " + this.y + "; " + this.z + ")");

    }

    double length (){

        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));

    }

    double scalar (Vector vector2){

        return this.x * vector2.x + this.y * vector2.y + this.z * vector2.z;

    }

    Vector vector_multiply(Vector vector2){

        int x = this.y * vector2.z - this.z * vector2.y;
        int y = this.z * vector2.x - this.x * vector2.z;
        int z = this.x * vector2.y - this.y * vector2.x;

        return new Vector(x, y, z);

    }

    int angle(Vector vector2){

        return (int) (Math.acos(this.scalar(vector2) / (this.length() + vector2.length())) * 57.2958);

    }

    Vector addition(Vector vector2){

        int x = this.x + vector2.x;
        int y = this.y + vector2.y;
        int z = this.z + vector2.z;

        return new Vector(x, y, z);

    }

    Vector subtraction(Vector vector2){

        int x = this.x - vector2.x;
        int y = this.y - vector2.y;
        int z = this.z - vector2.z;

        return new Vector(x, y, z);

    }
    

}
