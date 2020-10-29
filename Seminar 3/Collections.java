import java.util.*;

public class Collections {

    public static <T> Collection<T> noRepetitions(Collection<T> collection) {
        Set<T> set = new LinkedHashSet<T>(collection);
        collection.clear();
        collection.addAll(set);
        return collection ;
    }

    public static void compare2Lists(){
        long startTime, arrayTime, linkedTime;
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        final int N = 1000000;
        final int M = 10000;
        for(int i =0; i< N;i++){
            arrayList.add(Math.random());
            linkedList.add(Math.random());
        }
        startTime = System.currentTimeMillis();
        for(int i=0; i<M;i++){
            arrayList.get((int) Math.random()*(M-1));
        }
        arrayTime = System.currentTimeMillis() - startTime;
        System.out.println(arrayTime);
        startTime = System.currentTimeMillis();
        for(int i=0; i<N;i++){
            linkedList.get((int) Math.random()*(M-1));
        }
        linkedTime = System.currentTimeMillis() - startTime;
        System.out.println(linkedTime);
        if(linkedTime < arrayTime){
            System.out.println("LinkedList быстрее");
        }
        else if(linkedTime == arrayTime){
            System.out.println("Скорость одинаковая");
        }
        else{
            System.out.println("ArrayList быстрее");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<String>();
        people.add("Alex");
        people.add("Jack");
        people.add(1, "Kate");
        people.add("Alex");
        people.add(1, "Jack");
        for (String person: people) {
            System.out.println(person);
        }
        System.out.println("-----------------------");
        noRepetitions(people);
        for (String person: people) {
            System.out.println(person);
        }

    }
}