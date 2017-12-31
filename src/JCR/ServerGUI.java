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
        JPanel setInfo = new JPanel();
        JPanel onlineClients = new JPanel();
        JPanel showMessage = new JPanel(new GridLayout(2,1));

        setInfo.setBorder(BorderFactory.createTitledBorder("配置信息"));
        setInfo.setPreferredSize(new Dimension(580, 60));

        onlineClients.setBorder(BorderFactory.createTitledBorder("在线用户"));
        onlineClients.setPreferredSize(new Dimension(80, 300));

        showMessage.setBorder(BorderFactory.createTitledBorder("消息显示区"));
        showMessage.setPreferredSize(new Dimension(500, 300));


        lblInput = new JLabel("写消息");
        Input = new JTextField(6);

        lblOnlineNum = new JLabel("当前在线人数："+0);

        ChartHistory = new JTextArea();
        OnlineClients = new JTextArea();
        Send = new JButton("发送");
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


    //在textarea中增加文本
    public void addChartContent(String s){
        ChartHistory.append(s);
    }

    public void addOnlineClient(String s){
        OnlineClients.append(s+"\n");
    }

    //清空输入框的内容
    public void cleanInput(){
        Input.setText("");
    }

    //获取输入框内容
    public String getInput(){
        return Input.getText();
    }



}