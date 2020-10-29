import java.util.ArrayList;

public class Task5 {
    private int[] values;
    private int[] weight;

    public Task5(int[] values, int[] weight) {
        this.values = values;
        this.weight = weight;
    }

    public int[] getValues() {
        return values;
    }

    public int[] getWeight() {
        return weight;
    }

    public Integer outValue() {
        ArrayList<Integer> x = new ArrayList<Integer>();
        for (int i = 0; i < this.values.length; i++) {
            for (int k = 0; k <= this.weight[i]; k++) {
                x.add(values[i]);
            }
        }
        return x.get((int) (Math.random() * x.size()));
    }


    public static void main(String[] args) {
        Task5 obj = new Task5(new int[]{2, 4, 6}, new int[]{3, 7, 9});
        System.out.println(obj.outValue());
    }
}
