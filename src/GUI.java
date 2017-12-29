
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GUI implements ActionListener,ItemListener{
    private static String addStudentSQL(String name, String ID, String birthday, String number, String home, String sex){
        //hello = "������"+name.getText()+"\n���֤��"+ID.getText()+"\n���գ�"+birthday.getText()+"\nѧ�ţ�"+number.getText()+"\n���᣺"+cb.getSelectedItem().toString()+"\n�Ա�";
        return "INSERT into student(name, ID, birthday, number, home, sex) values('"+name+"', '"+ID+"','"+birthday+"','"+number+"', '"+home+"', '"+sex+"')";
    }

    private static String DeleteStudentSQLByID(String ID){
        return "DELETE from student where ID='"+ID+"'";
    }

    private static String UpdateStudentSQLByID(String name, String ID, String birthday, String number, String home, String sex){
        return "UPDATE student SET name='"+name+"', birthday='" + birthday + "', number='"+number+"', home='"+home+"', sex='"+sex+"' WHERE ID='"+ID+"'";
    }

    JTextField ID;
    JTextField name;
    JRadioButton sex1,sex2;
    ButtonGroup group = new ButtonGroup();
    JTextField birthday;
    JTextField number;
    JTextField result;
    JComboBox cb;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JTextArea ta;

    JLabel lblID,lblName,lblBirthday,lblNumber,lblHome,lblSex,lblResult;
    String[] homes = {"zhejiang","jiangsu","fujian","guangdong","beijing","shanghai"};
    public static void main(String[] args){
        JFrame f = new JFrame("ѧ����Ϣ¼���");
        Container contentPane = f.getContentPane();

        GUI xuesheng = new GUI();

        JPanel pane = xuesheng.init();

        f.getContentPane().add(pane);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






        f.setSize(600,500);
        f.setVisible(true);
    }






    public JPanel init(){
        JPanel jp = new JPanel(new FlowLayout());
        JPanel p1 = new JPanel(new GridLayout(2,1));
        ButtonGroup bg = new ButtonGroup();


        p1.setBorder(BorderFactory.createTitledBorder("�Ա�"));


        lblName = new JLabel("����");
        name = new JTextField(6);

        lblBirthday = new JLabel("����");
        birthday = new JTextField(6);

        lblHome = new JLabel("����");


        lblID = new JLabel("���֤");
        ID = new JTextField(12);

        lblNumber = new JLabel("ѧ��");
        number = new JTextField(11);

        lblResult = new JLabel("��ѧ�ɼ�");
        result = new JTextField(3);

        //lblSex = new JLabel("�Ա�");
        sex1 = new JRadioButton("man");
        sex2 = new JRadioButton("female");

        cb = new JComboBox(homes);

        btn1 = new JButton("����");
        btn2 = new JButton("���");
        btn3 = new JButton("ɾ��ID��Ӧѧ��");
        btn4 = new JButton("����ѧ����Ϣ");

        ta = new JTextArea();






        jp.add(lblID);jp.add(ID);
        jp.add(lblName);jp.add(name);
        group.add(sex1);
        group.add(sex2);
        jp.add(lblBirthday);jp.add(birthday);
        jp.add(lblNumber);jp.add(number);


        jp.add(lblHome);
        jp.add(cb);

        p1.add(sex1);
        p1.add(sex2);

        jp.add(btn1);
        jp.add(btn2);
        jp.add(btn3);
        jp.add(btn4);

        jp.add(p1);

        jp.add(ta);



        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);


        return jp;
    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource()==btn4){
            ta.append(ID.getText()+"\n");
            String hello;
            hello = "������"+name.getText()+"\n���֤��"+ID.getText()+"\n���գ�"+birthday.getText()+"\nѧ�ţ�"+number.getText()+"\n���᣺"+cb.getSelectedItem().toString()+"\n�Ա�";
            if (sex1.isSelected())  hello += sex1.getText();
            if (sex2.isSelected())  hello += sex2.getText();
            JOptionPane.showMessageDialog(null,hello);
            String mysql_driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/books";
            String user = "zalej";
            String password = "952440";





            try{
                Class.forName(mysql_driver);
                Connection conn = DriverManager.getConnection(url, user, password);
                if (!conn.isClosed())   System.out.println("connection success");
//            String name, author, press, press_time, ISBN;
//            Scanner sc = new Scanner(System.in);
//            System.out.print("name:");
//            name = sc.next();
//            System.out.print("author:");
//            author = sc.next();
//            System.out.print("press:");
//            press = sc.next();
//            System.out.print("press_time:");
//            press_time = sc.next();
//            System.out.print("ISBN:");
//            ISBN = sc.next();
                PreparedStatement psta = conn.prepareStatement("set names 'gbk'");
                psta.executeUpdate();



                //hello = "������"+name.getText()+"\n���֤��"+ID.getText()+"\n���գ�"+birthday.getText()+"\nѧ�ţ�"+number.getText()+"\n���᣺"+cb.getSelectedItem().toString()+"\n�Ա�";
                PreparedStatement pstaUpdate = conn.prepareStatement(UpdateStudentSQLByID(name.getText(), ID.getText(),birthday.getText(), number.getText(), cb.getSelectedItem().toString(),"man"));
                pstaUpdate.executeUpdate();



            }catch (SQLException se){
                se.printStackTrace();
            }catch (ClassNotFoundException ce){

            }


        }

        if (e.getSource()==btn3){
            ta.append(ID.getText()+"\n");
            String hello;
            hello = "������"+name.getText()+"\n���֤��"+ID.getText()+"\n���գ�"+birthday.getText()+"\nѧ�ţ�"+number.getText()+"\n���᣺"+cb.getSelectedItem().toString()+"\n�Ա�";
            if (sex1.isSelected())  hello += sex1.getText();
            if (sex2.isSelected())  hello += sex2.getText();
            JOptionPane.showMessageDialog(null,hello);
            String mysql_driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/books";
            String user = "zalej";
            String password = "952440";





            try{
                Class.forName(mysql_driver);
                Connection conn = DriverManager.getConnection(url, user, password);
                if (!conn.isClosed())   System.out.println("connection success");
//            String name, author, press, press_time, ISBN;
//            Scanner sc = new Scanner(System.in);
//            System.out.print("name:");
//            name = sc.next();
//            System.out.print("author:");
//            author = sc.next();
//            System.out.print("press:");
//            press = sc.next();
//            System.out.print("press_time:");
//            press_time = sc.next();
//            System.out.print("ISBN:");
//            ISBN = sc.next();
                PreparedStatement psta = conn.prepareStatement("set names 'gbk'");
                psta.executeUpdate();



                //hello = "������"+name.getText()+"\n���֤��"+ID.getText()+"\n���գ�"+birthday.getText()+"\nѧ�ţ�"+number.getText()+"\n���᣺"+cb.getSelectedItem().toString()+"\n�Ա�";
                PreparedStatement pstaUpdate = conn.prepareStatement(DeleteStudentSQLByID(ID.getText()));
                pstaUpdate.executeUpdate();



            }catch (SQLException se){
                se.printStackTrace();
            }catch (ClassNotFoundException ce){

            }


        }


        if (e.getSource()==btn1){
            ta.append(ID.getText()+"\n");
            String hello;
            hello = "������"+name.getText()+"\n���֤��"+ID.getText()+"\n���գ�"+birthday.getText()+"\nѧ�ţ�"+number.getText()+"\n���᣺"+cb.getSelectedItem().toString()+"\n�Ա�";
            if (sex1.isSelected())  hello += sex1.getText();
            if (sex2.isSelected())  hello += sex2.getText();
            JOptionPane.showMessageDialog(null,hello);
            String mysql_driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/books";
            String user = "zalej";
            String password = "952440";

            try{
                Class.forName(mysql_driver);
                Connection conn = DriverManager.getConnection(url, user, password);
                if (!conn.isClosed())   System.out.println("connection success");
//            String name, author, press, press_time, ISBN;
//            Scanner sc = new Scanner(System.in);
//            System.out.print("name:");
//            name = sc.next();
//            System.out.print("author:");
//            author = sc.next();
//            System.out.print("press:");
//            press = sc.next();
//            System.out.print("press_time:");
//            press_time = sc.next();
//            System.out.print("ISBN:");
//            ISBN = sc.next();
                PreparedStatement psta = conn.prepareStatement("set names 'gbk'");
                psta.executeUpdate();



                //hello = "������"+name.getText()+"\n���֤��"+ID.getText()+"\n���գ�"+birthday.getText()+"\nѧ�ţ�"+number.getText()+"\n���᣺"+cb.getSelectedItem().toString()+"\n�Ա�";
                PreparedStatement pstaUpdate = conn.prepareStatement(addStudentSQL(name.getText(), ID.getText(),birthday.getText(), number.getText(), cb.getSelectedItem().toString(), "mail"));
                pstaUpdate.executeUpdate();



            }catch (SQLException se){
                se.printStackTrace();
            }catch (ClassNotFoundException ce){

            }


        }









        if (e.getSource()==btn2) {
            name.setText("");
            ID.setText("");
            birthday.setText("");
            number.setText("");
            ta.setText("");
            cb.setSelectedIndex(0);
            if (sex1.isSelected())
                sex1.setSelected(false);

            if (sex2.isSelected())
                sex2.setSelected(false);



        }
        //System.exit(0);


    }

    public void itemStateChanged(ItemEvent e){

    }




}
