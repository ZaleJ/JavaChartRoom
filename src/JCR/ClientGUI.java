package JCR;

import javafx.scene.chart.Chart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ClientGUI{

    JTextField Input, Port, IP, Name;
    JButton Send, Conn, Dcon;
    JTextArea ChartHistory = new JTextArea(480, 280);
    JTextArea onlineMember = new JTextArea(40, 280);

    JLabel lblInput, lblPort, lblIP, lblName;
//    public static void main(String[] args){
//        JFrame f = new JFrame("JAVA聊天室");
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

        JPanel conInfo = new JPanel();
        JPanel onlineClients = new JPanel();
        JPanel showMessage = new JPanel();

        conInfo.setBorder(BorderFactory.createTitledBorder("连接信息"));
        conInfo.setPreferredSize(new Dimension(580, 60));

        onlineClients.setBorder(BorderFactory.createTitledBorder("在线用户"));
        onlineClients.setPreferredSize(new Dimension(80, 300));

        showMessage.setBorder(BorderFactory.createTitledBorder("消息显示区"));
        showMessage.setPreferredSize(new Dimension(500, 300));

        lblInput = new JLabel("写消息");
        Input = new JTextField(20);
        ChartHistory = new JTextArea();
        onlineMember = new JTextArea();

        Send = new JButton("发送");

        lblPort = new JLabel("端口:");
        Port = new JTextField(6);

        lblIP = new JLabel("服务器IP：");
        IP = new JTextField(6);

        lblName = new JLabel("姓名：");
        Name = new JTextField(6);

        Conn = new JButton("连接");
        Dcon = new JButton("断开");

        conInfo.add(lblPort);conInfo.add(Port);
        conInfo.add(lblIP);conInfo.add(IP);
        conInfo.add(lblName);conInfo.add(Name);
        conInfo.add(Conn);conInfo.add(Dcon);

        showMessage.add(ChartHistory);

        onlineClients.add(onlineMember);

        jp.add(conInfo);
        jp.add(onlineClients);
        jp.add(showMessage);

        jp.add(lblInput);jp.add(Input);
        jp.add(Send);
        //jp.add(ChartHistory);
        Port.setText("6666");
        IP.setText("127.0.0.1");
        Name.setText(new CountClients().num+"");

        return jp;
    }



    //在textarea中增加文本
    public void addChartContent(String s){
        ChartHistory.append(s);
    }

    public void addOnLineMember(String s){
        onlineMember.append(s);
    }

    //清空输入框的内容
    public void cleanInput(){
        Input.setText("");
    }

    public String getInput(){
        return Input.getText();
    }

    public String getPort(){
        return Port.getText();
    }

    public String getIP(){
        return IP.getText();
    }





}