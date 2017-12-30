
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI implements ActionListener{

    JTextField Input;
    JButton Send;
    JTextArea ChartHistory;

    JLabel lblInput, lblOnlineNum;

    int OnlineNum=0;

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
        JPanel p1 = new JPanel(new GridLayout(2,1));
        p1.setBorder(BorderFactory.createTitledBorder("聊天内容"));
        lblInput = new JLabel("写消息");
        Input = new JTextField(6);

        lblOnlineNum = new JLabel("当前在线人数："+0);
        ;

        ChartHistory = new JTextArea();
        Send = new JButton("发送");
        jp.add(lblOnlineNum);
        jp.add(lblInput);jp.add(Input);
        jp.add(Send);
        jp.add(ChartHistory);
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

    //清空输入框的内容
    public void cleanInput(){
        Input.setText("");
    }

    public String getInput(){
        return Input.getText();
    }



}