package JCR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI implements ActionListener{

    JTextField Input;
    JButton Send;
    JTextArea ChartHistory;
    JTextArea OnlineClients;

    JLabel lblInput, lblOnlineNum;

    static int OnlineNum=0;

//    public static void main(String[] args){
//        JFrame f = new JFrame("JAVA������");
//        Container contentPane = f.getContentPane();
//        JCR.ClientGUI gui = new JCR.ClientGUI();
//        JPanel pane = gui.init();
//        f.getContentPane().add(pane);
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        f.setSize(600,500);
//        f.setVisible(true);
//        JCR.Client c = new JCR.Client();
//    }






    public JPanel init(){
        JPanel jp = new JPanel(new FlowLayout());
        JPanel p1 = new JPanel(new GridLayout(2,1));
        p1.setBorder(BorderFactory.createTitledBorder("��������"));
        lblInput = new JLabel("д��Ϣ");
        Input = new JTextField(6);

        lblOnlineNum = new JLabel("��ǰ����������"+0);

        ChartHistory = new JTextArea();
        OnlineClients = new JTextArea();
        Send = new JButton("����");
        jp.add(lblOnlineNum);
        jp.add(lblInput);jp.add(Input);
        jp.add(Send);
        jp.add(ChartHistory);
        jp.add(OnlineClients);
        Send.addActionListener(this);
        return jp;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==Send){
            //ta.append(ID.getText()+"\n");
            JOptionPane.showMessageDialog(null,"hello");
            ChartHistory.append("+1");
        }
    }


    //��textarea�������ı�
    public void addChartContent(String s){
        ChartHistory.append(s);
    }

    public void addOnlineClient(String s){
        OnlineClients.append(s+"\n");
    }

    //�������������
    public void cleanInput(){
        Input.setText("");
    }

    //��ȡ���������
    public String getInput(){
        return Input.getText();
    }



}