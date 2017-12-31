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
        JPanel setInfo = new JPanel();
        JPanel onlineClients = new JPanel();
        JPanel showMessage = new JPanel(new GridLayout(2,1));

        setInfo.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
        setInfo.setPreferredSize(new Dimension(580, 60));

        onlineClients.setBorder(BorderFactory.createTitledBorder("�����û�"));
        onlineClients.setPreferredSize(new Dimension(80, 300));

        showMessage.setBorder(BorderFactory.createTitledBorder("��Ϣ��ʾ��"));
        showMessage.setPreferredSize(new Dimension(500, 300));


        lblInput = new JLabel("д��Ϣ");
        Input = new JTextField(6);

        lblOnlineNum = new JLabel("��ǰ����������"+0);

        ChartHistory = new JTextArea();
        OnlineClients = new JTextArea();
        Send = new JButton("����");
        setInfo.add(lblOnlineNum);
        onlineClients.add(OnlineClients);
        showMessage.add(ChartHistory);
        jp.add(setInfo);
        jp.add(onlineClients);
        jp.add(showMessage);
        jp.add(lblInput);jp.add(Input);
        jp.add(Send);
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