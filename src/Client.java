import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client implements ActionListener {
	public int port=6666;
	Socket socket=null;
    String LineContext;

    static ClientGUI gui = new ClientGUI();

    public static void main(String[] args){
        JFrame f = new JFrame("JAVA�����ҿͻ���");
        Container contentPane = f.getContentPane();
        JPanel pane = gui.init();
        f.getContentPane().add(pane);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(650,650);
        f.setVisible(true);

        new Client();
	}



	public Client(){
		try {
            gui.Send.addActionListener(this);
            gui.Conn.addActionListener(this);
            gui.Dcon.addActionListener(this);
			socket=new Socket("127.0.0.1",port);
			new Cthread().start();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket .getInputStream()));
			String msg1;
			while ((msg1 = br.readLine()) != null) {
				System.out.println(msg1);
				//��ӭ����xxx��������x�ˣ� xxx˵xxx
                gui.addChartContent(msg1+"\n");
			}
		}
		catch (Exception e) {
		}
	}
	class Cthread extends Thread{
		public void run() {
		    //���Խ������������Ϊ�ı����ı�����
            //����������������ǿӵ���������ôҪ��ô�ģ�
			try {
				BufferedReader re = new BufferedReader(new InputStreamReader(getInputStreamFromString(gui.getInput())));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
//                JOptionPane.showMessageDialog(null,gui.Input.getText());

//				while (true) {
//                    LineContext = re.readLine();
//					pw.println	(LineContext);
//					gui.addChartContent(LineContext);
//				}
                if (new String(gui.Input.getText()).length()!=0){
                    LineContext=gui.Input.getText();
                    pw.println(LineContext);
                    gui.addChartContent(LineContext);
                }

			}catch (Exception e) {
				e.printStackTrace();
			}
		}




    }

    //��stirngת��Ϊinputstream
    public InputStream getInputStreamFromString(String str){
        InputStream in=new ByteArrayInputStream(str.getBytes());
        return in;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==gui.Send){
            //ta.append(ID.getText()+"\n");
            JOptionPane.showMessageDialog(null,"hello");
            try {
                BufferedReader re = new BufferedReader(new InputStreamReader(getInputStreamFromString(gui.getInput())));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
//                JOptionPane.showMessageDialog(null,gui.Input.getText());

//				while (true) {
//                    LineContext = re.readLine();
//					pw.println	(LineContext);
//					gui.addChartContent(LineContext);
//				}
                if (new String(gui.Input.getText()).length()!=0){
                    LineContext=gui.Input.getText();
                    pw.println(LineContext);
                    //gui.addChartContent(LineContext);
                }

            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource()==gui.Conn){
            JOptionPane.showMessageDialog(null,"�ͻ���������");
        }
    }


}
