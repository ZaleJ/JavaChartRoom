
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI implements ActionListener{

    JTextField Input;
    JButton Send;
    JTextArea ChartHistory;

    JLabel lblInput;
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
        lblInput = new JLabel("姓名");
        Input = new JTextField(6);
        ChartHistory = new JTextArea();
        Send = new JButton("发送");
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

    public void addChartContent(String s){
        ChartHistory.append(s);
    }


}