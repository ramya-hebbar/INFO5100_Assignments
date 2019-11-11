package Question2;

import javax.swing.*;
import java.awt.*;

public abstract class MainFrame extends JFrame {

    public MainFrame() {
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
        setSize(500,300);
        setVisible(true);
    }
}