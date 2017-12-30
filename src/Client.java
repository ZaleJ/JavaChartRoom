import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
	public int port=6666;
	Socket socket=null;
    String LineContext;

    static ClientGUI gui = new ClientGUI();

    public static void main(String[] args){
        JFrame f = new JFrame("JAVA������");
        Container contentPane = f.getContentPane();
        JPanel pane = gui.init();
        f.getContentPane().add(pane);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(600,500);
        f.setVisible(true);

		new Client();
	}



	public Client(){
		try {
			socket=new Socket("127.0.0.1",port);
			new Cthread().start();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket .getInputStream()));
			String msg1;
			while ((msg1 = br.readLine()) != null) {
				System.out.println(msg1);

				//��ӭ����xxx��������x��
                gui.addChartContent(msg1+"\n");
			}
		}
		catch (Exception e) {
		}
	}
	class Cthread extends Thread{
		public void run() {
			try {
				BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
//                JOptionPane.showMessageDialog(null,gui.Input.getText());
				while (true) {
                    LineContext = re.readLine();
					pw.println	(LineContext);

				}

			}catch (Exception e) {
				e.printStackTrace(); 
			}
		}
	}
}
