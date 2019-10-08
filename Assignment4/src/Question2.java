import java.util.Scanner;

abstract class MoodyObject {

    protected abstract String getMood();

    public void queryMood() {
        System.out.println(getMood());

    }

    public abstract void expressFeelings();

}

class HappyObject extends MoodyObject {
    @Override
    protected String getMood() {
        return "I feel happy today!\n";
    }

    @Override
    public void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    public String toString() {
        return "Observation: Subject laughs a lot";
    }
}

class SadObject extends MoodyObject {
    @Override
    protected String getMood() {
        return "I feel sad today!\n";
    }

    @Override
    public void expressFeelings() {
        System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }

    public String toString() {
        return "Observation: Subject cries a lot";
    }
}

class PsychiatristObject {

    public void examine(MoodyObject moodyObject) {
        System.out.println("\nHow are you feeling today?");
        System.out.println(moodyObject.getMood());
    }

    public void observe(MoodyObject moodyObject) {
        moodyObject.expressFeelings();
        System.out.println(moodyObject.toString());
    }
}

public class Question2 {

    public static void main(String[] args) {

        PsychiatristObject pObj = new PsychiatristObject();

        HappyObject hObject = new HappyObject();

        pObj.examine(hObject);
        pObj.observe(hObject);

        SadObject sadObject = new SadObject();

        pObj.examine(sadObject);
        pObj.observe(sadObject);
    }
}
