package com.com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.JFrame.*;

public class SWINGG extends dbms{
    //Complaint form
    private static int a;
    static <a> void thirdFrame(){

        JFrame f2 = new JFrame();
        f2.setDefaultCloseOperation(HIDE_ON_CLOSE);
        f2.setSize(500,600);
        f2.setLayout(null);
        f2.setVisible(true);
        try {
            f2.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\dakshi\\IdeaProjects\\FirstJavaProjectCWH\\src\\com\\com\\company\\form.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel lab = new JLabel("<html><font color='white'>COMPLAINT FORM</font></html>");
        lab.setFont(new Font("Helvetica", Font.BOLD, 40));
        lab.setBounds(50, 10, 1000, 100);
        f2.add(lab);

        //form contents
        String[] optionsToChoose = {"Water dept", "Electricity dept", "Furniture problems", "IT dept", "Other"};
        JLabel l01 = new JLabel("<html><font color='white'>Block: </font></html>");
        JTextField tf1 = new JTextField();
        JLabel l02 = new JLabel("<html><font color='white'>Room number: </font></html>");
        JTextField tf2 = new JTextField();
        JLabel l03 = new JLabel("<html><font color='white'>Date of availability<br>[dd-mm-yy]: </font></html>");
        JTextField tf3 = new JTextField();
        l01.setBounds(50, 100, 100, 50);
        tf1.setBounds(50, 135, 100,20);
        l02.setBounds(50, 180, 100, 50);
        tf2.setBounds(50, 215, 100,20);
        l03.setBounds(300, 90, 200,100);
        tf3.setBounds(300, 160, 100,20);

        //drop-down
        JLabel l04 = new JLabel("<html><font color='white'>Select Department:</font></html>");
        l04.setBounds(50, 250, 100, 50);
        JComboBox<String> jcb = new JComboBox<>(optionsToChoose);
        jcb.setBounds(50, 295, 140, 20);

        JLabel l05 = new JLabel("<html><font color='white'>Complaint details:</font></html>");
        l05.setBounds(50, 350, 100, 50);
        JTextArea tf4 = new JTextArea();
        tf4.setBounds(50, 395,350, 100);
        JButton b = new JButton("Submit");
        b.setBounds(320, 500, 80, 30);

        f2.add(l01);
        f2.add(l02);
        f2.add(l03);
        f2.add(tf1);
        f2.add(tf2);
        f2.add(tf3);
        f2.add(l04);
        f2.add(jcb);
        f2.add(l05);
        f2.add(tf4);
        f2.add(b);

        ///function on button
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f2.dispose();
                if(tf4.getText()!=""){
                    a++;
                    dbms.comp_no.add(a);
                    dbms.dscrptn.add(tf4.getText());
                    dbms.status.add("<html><font color='green'>processing</font></html>");
                    JOptionPane.showMessageDialog(f2, "Ticket no.: "+a+"\nReceived successfully!");
                }
            }
        });
    }
    //view ticket student
    static void Fframe(){
        JFrame f4 = new JFrame();
        f4.setDefaultCloseOperation(HIDE_ON_CLOSE);
        f4.setSize(500,600);
        f4.setLayout(null);
        f4.setVisible(true);
        try {
            f4.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\dakshi\\IdeaProjects\\FirstJavaProjectCWH\\src\\com\\com\\company\\form.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int len = dbms.comp_no.size();
        String data[][] = new String[len][3];
        for (int i=0; i<len; i++){
            data[i][0]= String.valueOf(dbms.comp_no.get(i));
            data[i][1]=dbms.dscrptn.get(i);
            data[i][2]=dbms.status.get(i);
        }
//        String data[][]={ {"1","Water blockage","<html><font color='red'>closed</font></html>"},
//                          {"2","Fan not working","<html><font color='green'>processing</font></html>"}};
        String column[]={"Ticket no.","Description","Status"};
        JTable j=new JTable(data,column);
        JTableHeader header = j.getTableHeader();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(header, BorderLayout.NORTH);
        panel.add(j, BorderLayout.CENTER);
        j.setBounds(10,30,467,400);
        panel.setBounds(10,10,467,400);
        JScrollPane sp=new JScrollPane(j);
        f4.add(j);
        f4.add(panel);
        f4.add(sp);

        JButton but = new JButton("Close");
        but.setBounds(210,470,80,30);
        f4.add(but);

        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //f.setVisible(true);
                f4.setVisible(false);
            }
        });
    }

    //view ticket admin
    static void FFframe(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton but = new JButton("Done");
        but.setBounds(200,300,80,30);
        frame.add(but);

        ArrayList<Integer> indexes = new ArrayList<Integer>();
//-------------------------------------------------------
        System.out.println(dbms.status);
        for(int i=0; i<dbms.status.size(); i++){
            if(dbms.status.get(i).contains("processing"))
            {
                //String id = Integer.toString(i);
                indexes.add(i);
            }
        }
        int len = indexes.size();
        Object data[][] = new Object[len][3];
        for (int i=0; i<len; i++){
            //String s = "b"+ String.valueOf(i);
            //JButton s = new JButton("Resolved");
            data[i][0]= String.valueOf(dbms.comp_no.get(indexes.get(i)));
            data[i][1]=dbms.dscrptn.get(indexes.get(i));
            data[i][2]=new Boolean(false);
        }
////        String data[][]={ {"1","Water blockage","<html><font color='red'>closed</font></html>"},
////                          {"2","Fan not working","<html><font color='green'>processing</font></html>"}};
        String column[]={"Ticket no.","Description","Resolved"};

        TableModel model = new EditableTableModel(column, data);
        JTable table = new JTable(model);
        table.createDefaultColumnsFromModel();
        frame.add(new JScrollPane(table));
        frame.setSize(500, 500);
        frame.setVisible(true);

//        TableModel model= new TableModel();
//
//        table =new JTable( );
//        DefaultTableModel model = new DefaultTableModel(data, column);
//        JTable j= new JTable(data, column);
//        //--------------------------------------
//        j.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent evt) {
//                int row = j.rowAtPoint(evt.getPoint());
//                int col = j.columnAtPoint(evt.getPoint());
//                //-----------------------------------------------------
//                if(col==3) {
//                    int result = JOptionPane.showConfirmDialog(ff, "ticket resolved?", "Change status",
//                            JOptionPane.YES_NO_OPTION,
//                            JOptionPane.QUESTION_MESSAGE);
//                    if (result == JOptionPane.YES_OPTION) {
//                        j.setValueAt("<html><font color='red'>closed</font></html>", row, col);
//                        int n = (int) j.getValueAt(row,1);
//                        dbms.status.set(n,"<html><font color='red'>closed</font></html>");
//                    } else if (result == JOptionPane.NO_OPTION) {} else {}}}});
        //JTable j=new JTable(data,column);
//        JTableHeader header = j.getTableHeader();
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        panel.add(header, BorderLayout.NORTH);
//        panel.add(j, BorderLayout.CENTER);
//        j.setBounds(10,30,467,400);
//        panel.setBounds(10,10,467,400);
//        JScrollPane sp=new JScrollPane(j);
//        ff.add(j);
//        ff.add(panel);
//        ff.add(sp);
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //f.setVisible(true);
                int i;
                for (i = 0; i < len ; i++){
                    Object valueAt = table.getValueAt(i, 2);
                    Boolean v = (Boolean) valueAt;
                    if(v==true){
                        String q = table.getValueAt(i,0).toString();
                        int b = Integer.parseInt(q);
                        dbms.status.set(dbms.comp_no.indexOf(b),"<html><font color='red'>closed</font></html>");
                    }
                }
                frame.setVisible(false);
                JOptionPane.showMessageDialog(frame, "Status updated!");
            }
        });

        }

    //add student
    static void forthFrame(){
        JFrame f2 = new JFrame();
        f2.setDefaultCloseOperation(HIDE_ON_CLOSE);
        f2.setSize(450,400);
        f2.setLayout(null);
        f2.setVisible(true);
        try {
            f2.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\dakshi\\IdeaProjects\\FirstJavaProjectCWH\\src\\com\\com\\company\\form.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel lab = new JLabel("<html><font color='white'>NEW STUDENT</font></html>");
        lab.setFont(new Font("Helvetica", Font.BOLD, 40));
        lab.setBounds(50, 10, 1000, 100);
        f2.add(lab);

        //form contents
        JLabel l01 = new JLabel("<html><font color='white'>Student Name:  </font></html>");
        JTextField tf1 = new JTextField();
        JLabel l02 = new JLabel("<html><font color='white'>Email ID: </font></html>");
        JTextField tf2 = new JTextField();
        JLabel l03 = new JLabel("<html><font color='white'>Password: </font></html>");
        JTextField tf3 = new JTextField();
        JLabel l04 = new JLabel("<html><font color='white'>Room no.: </font></html>");
        JTextField tf4 = new JTextField();
        l01.setBounds(50, 100, 100, 50);
        tf1.setBounds(50, 135, 100,20);
        l02.setBounds(50, 180, 100, 50);
        tf2.setBounds(50, 215, 100,20);
        l03.setBounds(250, 180, 100,50);
        tf3.setBounds(250, 215, 100,20);
        l04.setBounds(250, 100, 100, 50);
        tf4.setBounds(250,135, 100, 20);

        JButton b1 = new JButton("Add");
        b1.setBounds(90, 300, 80, 30);
        JButton b2 = new JButton("Cancel");
        b2.setBounds(200, 300, 80, 30);

        f2.add(l01);
        f2.add(tf1);
        f2.add(l02);
        f2.add(tf2);
        f2.add(l03);
        f2.add(tf3);
        f2.add(l04);
        f2.add(tf4);
        f2.add(b1);
        f2.add(b2);

        //adding button func
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f2.dispose();
                if(tf1.getText()!="" && tf2.getText()!="" && tf3.getText()!="" && tf4.getText()!=""){
                    a++;
                    dbms.sname.add(tf1.getText());
                    dbms.id.add(tf2.getText());
                    dbms.pswd.add(tf3.getText());
                    f2.dispose();
                    JOptionPane.showMessageDialog(f2, "New Student added!");
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f2.dispose();
                JOptionPane.showMessageDialog(f2, "New Student added!");}});
    }
    //home page student
    static void newFrame(JFrame f){
        JFrame f1 = new JFrame();
        f1.setDefaultCloseOperation(HIDE_ON_CLOSE);
        f1.setSize(1200,720);
        f1.setLayout(null);
        f1.setVisible(true);
        try {
            f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\dakshi\\IdeaProjects\\FirstJavaProjectCWH\\src\\com\\com\\company\\collegeBackground.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //JButton b1 = new JButton("Back");
        JButton b = new JButton("Log out");
        //b1.setBounds(5,5,90,30);
        b.setBounds(1097,5,80,30);
        //f1.add(b1);
        f1.add(b);

        JLabel label = new JLabel("WELCOME TO HOSTELEZ");
        label.setFont(new Font("Helvetica", Font.BOLD,50));

        label.setBounds(250,100,1000,100);
        f1.add(label);

        JButton b1 = new JButton("New Ticket");
        //JButton b2 = new JButton("Edit Ticket");
        JButton b3 = new JButton("View Ticket");
        b1.setBounds(400,200,150,100);
        b3.setBounds(600,200,150,100);
        f1.add(b1);
        f1.add(b3);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                thirdFrame();
                //f1.dispose();
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Fframe();
                //f1.dispose();
            }
        });
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.setVisible(true);
                f1.setVisible(false);
            }
        });
    }

    //home page admin
    static void nextFrame(JFrame f){
        JFrame f1 = new JFrame();
        f1.setDefaultCloseOperation(HIDE_ON_CLOSE);
        f1.setSize(1200,720);
        f1.setLayout(null);
        f1.setVisible(true);
        try {
            f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\dakshi\\IdeaProjects\\FirstJavaProjectCWH\\src\\com\\com\\company\\collegeBackground.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //JButton b1 = new JButton("Back");
        JButton b = new JButton("Log out");
        //b1.setBounds(5,5,90,30);
        b.setBounds(1097,5,80,30);
        //f1.add(b1);
        f1.add(b);

        JLabel label = new JLabel("WELCOME, ADMIN!");
        label.setFont(new Font("Helvetica", Font.BOLD,50));

        label.setBounds(290,100,1000,100);
        f1.add(label);

        JButton b1 = new JButton("Add Student");
        //JButton b2 = new JButton("Edit Ticket");
        JButton b3 = new JButton("View Ticket");
        b1.setBounds(400,200,150,100);
        b3.setBounds(600,200,150,100);
        f1.add(b1);
        f1.add(b3);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                forthFrame();
                //f1.dispose();
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                FFframe();
                //f1.dispose();
            }
        });
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.setVisible(true);
                f1.setVisible(false);
            }
        });
    }
    public static void main(String[] args) {

    //login page
        //creating frame
        JFrame f = new JFrame("LOGIN WINDOW");
        f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        //panel creation
        //adding first panel
        JPanel panel1=new JPanel();
        JLabel l1 = new JLabel("LOGIN");
        l1.setFont(new Font("Helvetica", Font.BOLD, 70));
        l1.setSize(50 ,50);
        panel1.add(l1);
        panel1.setBounds(0,0,800,100);
        Color c1 = new Color(51,153,255);
        panel1.setBackground(Color.getHSBColor(69,69,96));
        f.add(panel1);

        f.setSize(800,600);
        f.setLayout(null);
        f.setVisible(true);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.darkGray);
        JButton b = new JButton("Log in");
        JLabel label1 = new JLabel("<html><font color='white'> EMAIL ID: </font></html>");
        JLabel label2 = new JLabel("<html><font color='white'>  PASSWORD: </font></html>");
        JPasswordField pf = new JPasswordField(15);
        JTextField tf1 = new JTextField(15);
        p2.setSize(300, 200);
        label1.setBounds(10, 30, 100, 20);
        label2.setBounds(10,65,  100,  20);
        tf1.setBounds(85, 30, 150, 20);
        pf.setBounds(85, 65, 150, 20);
        b.setBounds(110, 150, 80, 20);
        p2.add(label1);
        p2.add(label2);
        p2.add(b);
        p2.add(tf1);
        p2.add(pf);
        p2.setBounds(240,180,300,200);
        //p2.setSize(300, 200);
        //p2.setLocation(240, 180);
        p2.setLayout(null);
        p2.setVisible(true);
        f.getContentPane().add(p2);

        //function on button
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String s=String.valueOf(pf.getPassword());
                System.out.println(s);
                if(dbms.id.contains(tf1.getText())){
                    int n = id.indexOf(tf1.getText());
                    if(dbms.pswd.get(n).equals(s)){
                        newFrame(f);
                        f.setVisible(false);
                        pf.setText("");
                    }else{
                        System.out.println("login failed!");
                        JLabel label3 = new JLabel("<html><font color='red'>Invalid! Try again.</font></html>");
                        label3.setBounds(100, 100, 100, 20);
                        p2.add(label3);
                        tf1.setText("");
                        pf.setText("");
                    }
                }
                else if(tf1.getText().equals("admin@bennett.edu.in") && s.equals("Admin")){
                    nextFrame(f);
                    f.setVisible(false);
                    pf.setText("");
                }
                else{
                    JLabel label3 = new JLabel("<html><font color='red'>Invalid! Try again.</font></html>");
                    label3.setBounds(100, 100, 100, 20);
                    p2.add(label3);
                    tf1.setText("");
                    pf.setText("");
                }
            }
        });

    }

}
class EditableTableModel extends AbstractTableModel
{
    String[] column;
    Object[][] data;
    int rowCount;
    public EditableTableModel(String[] columnTitles, Object[][] dataEntries)
    {
        this.column = columnTitles;
        this.data = dataEntries;
    }
    public int getRowCount()
    {
        return data.length;
    }
    public int getColumnCount()
    {
        return column.length;
    }
    public Object getValueAt(int row, int column)
    {
        return data[row][column];
    }
    public String getColumnName(int colum)
    {
        return column[colum];
    }
    public Class getColumnClass(int column)
    {
        return getValueAt(0, column).getClass();
    }
    public boolean isCellEditable(int row, int column)
    {
        return true;
    }
    public void setValueAt(Object value, int row, int column)
    {
        data[row][column] = value;
    }
}