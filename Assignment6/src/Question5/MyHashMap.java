package Question5;

import java.util.ArrayList;

public class MyHashMap {
    ArrayList<Integer> keys;
    ArrayList<Integer> values;

    public MyHashMap() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public void put(int key, int value) {

        //check if key exists

        int existingIndex = this.keys.indexOf(key);

        if(existingIndex >= 0) {
            this.values.remove(existingIndex);
            this.values.add(existingIndex, value);
        }
        else {
            this.keys.add(key);
            this.values.add(this.keys.size()-1, value);
        }
    }

    public int get(int key) {

        int indexOfKey = this.keys.indexOf(key);

        if(indexOfKey >= 0) {
            return this.values.get(indexOfKey);
        }

        return -1;
    }

    public void remove(int key) {
        int indexOfKey = this.keys.indexOf(key);

        this.keys.remove(indexOfKey);

        this.values.remove(indexOfKey);
    }

    @Override
    public String toString() {

        String outputStr = new String();

        for (int i = 0; i < keys.size(); i++) {
            outputStr = outputStr + "Key - " + keys.get(i) + " Value - " + values.get(i)  + "\n";
        }

        return outputStr;
    }
}
