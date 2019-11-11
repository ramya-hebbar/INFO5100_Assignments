package Question1;

import javax.swing.*;
import java.awt.*;

public abstract class Baseframe extends JFrame {

    public Baseframe() {
        create();

        Container con = getContentPane();
        add(con);
        addListeners();
        makeItVisible();
    }

    public abstract void create();

    public abstract void add(Container con);

    public abstract void addListeners();

    public void makeItVisible() {
        setSize(300,400);
        setVisible(true);
    }
}
