package Question5;

public class Question5 {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        hashMap.put(1, 1);
        hashMap.put(2, 2);

        System.out.println(hashMap);

        int fetch = hashMap.get(1);
        if(fetch > 0) {
            System.out.println("\nValue retrieved is : " + fetch);
        }
        else {
            System.out.println("\nValue not found");
        }

        fetch = hashMap.get(3);
        if(fetch > 0) {
            System.out.println("\nValue retrieved is : " + fetch);
        }
        else {
            System.out.println("\nValue not found");
        }

        hashMap.put(2, 1);

        System.out.println(hashMap);

        fetch = hashMap.get(2);
        if(fetch > 0) {
            System.out.println("\nValue retrieved is : " + fetch);
        }
        else {
            System.out.println("\nValue not found");
        }

        hashMap.remove(2);
        System.out.println(hashMap);

        fetch = hashMap.get(2);
        if(fetch > 0) {
            System.out.println("\nValue retrieved is : " + fetch);
        }
        else {
            System.out.println("\nValue not found");
        }
    }
}

