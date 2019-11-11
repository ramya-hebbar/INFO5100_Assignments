package Question2;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;

class StudentModel implements TableModel {

    private StudentsManager manager;

    public StudentModel(StudentsManager manager) {
        this.manager = manager;
    }

    @Override
    public int getRowCount() {
        return manager.getStudentCount();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0: {
                return "Student ID";
            }

            case 1: {
                return "Name";
            }

            case 2: {
                return "Gender";
            }

            case 3: {
                return "GPA";
            }
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = manager.getStudents().get(rowIndex);

        switch (columnIndex) {
            case 0: {
                return s.getId();
            }

            case 1: {
                return s.getName();
            }

            case 2: {
                return s.getGender();
            }

            case 3: {
                return s.getGpa();
            }
        }

        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {

//        rowData[row][col] = value;
//        fireTableCellUpdated(rowIndex, columnIndex);

        Student s = (Student) o;
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {


    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }

    //add student
    public String addStudent(Student student) {
        String result = manager.addStudent(student);
//        StudentUI.set

        return result;
    }
}

public class StudentUI extends MainFrame implements TableModelListener{

    private JLabel idLabel, nameLabel, genderLabel, gpaLabel;
    private JTextField idTF, nameTF, gpaTF;
    private JComboBox genderOptions;
    private JButton addButton;
    private JTable studentsTable;

    private StudentModel model;

    @Override
    public void create() {
        idLabel = new JLabel("Student ID");
        nameLabel = new JLabel("Student Name");
        genderLabel = new JLabel("Gender");
        gpaLabel = new JLabel("GPA");

        idTF = new JTextField(20);
        nameTF = new JTextField(20);
        gpaTF = new JTextField(3);

        genderOptions = new JComboBox(new Gender[] {Gender.MALE, Gender.FEMALE});

        addButton = new JButton("Add Student");

        try {
            model = new StudentModel(new StudentsManager());
        }
        catch (Exception e) {

        }

        studentsTable = new JTable(model);
        studentsTable.getModel().addTableModelListener(this);
    }

    @Override
    public void add(Container con) {
        GridLayout gl = new GridLayout(2, 1);
        con.setLayout(gl);

        addFirstComponent(con);
        addSecondComponent(con);
        addTable(con);
    }

    private void addFirstComponent(Container con) {
        JPanel panel = new JPanel();
        panel.add(idLabel);
        panel.add(idTF);
        panel.add(genderLabel);
        panel.add(genderOptions);
        panel.add(addButton);

        con.add(panel);
    }

    private void addSecondComponent(Container con) {
        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameTF);
        panel.add(gpaLabel);
        panel.add(gpaTF);

        con.add(panel);
    }

    private void addTable(Container con) {
        con.add(new JScrollPane(studentsTable), "South");
        studentsTable.setFillsViewportHeight(true);
    }

    @Override
    public void addListeners() {
        addButton.addActionListener((e) -> addNewStudent());
    }

    private void addNewStudent() {
        Gender selectedGender = (Gender) genderOptions.getSelectedItem();

        Student student = new Student(idTF.getText(), nameTF.getText(), selectedGender, Float.parseFloat(gpaTF.getText()));
        String result = model.addStudent(student);
        JOptionPane.showMessageDialog(this, result);

        idTF.setText("");
        nameTF.setText("");
        gpaTF.setText("");
        genderOptions.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new StudentUI();
    }

    @Override
    public void tableChanged(TableModelEvent tableModelEvent) {
        repaint();
    }
}
