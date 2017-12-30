
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI{

    JTextField Input;
    JButton Send;
    JTextArea ChartHistory;

    JLabel lblInput, lblPort, lblIP, lblName;
//    public static void main(String[] args){
//        JFrame f = new JFrame("JAVA聊天室");
//        Container contentPane = f.getContentPane();
//        ClientGUI gui = new ClientGUI();
//        JPanel pane = gui.init();
//        f.getContentPane().add(pane);
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        f.setSize(600,500);
//        f.setVisible(true);
//        Client c = new Client();
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
        Send = new JButton("发送");

        lblPort = new JLabel("端口");
        conInfo.add(lblPort);

        jp.add(conInfo);
        jp.add(onlineClients);
        jp.add(showMessage);

        jp.add(lblInput);jp.add(Input);
        jp.add(Send);
        jp.add(ChartHistory);

        return jp;
    }



    //在textarea中增加文本
    public void addChartContent(String s){
        ChartHistory.append(s);
    }

    //清空输入框的内容
    public void cleanInput(){
        Input.setText("");
    }

    public String getInput(){
        return Input.getText();
    }



}