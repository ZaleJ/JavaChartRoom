package JCR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Client implements ActionListener {
	public int port=6666;
	public String ip="127.0.0.1";
	Socket socket=null;
    String LineContext;
    ArrayList<String> clients = new ArrayList<String> ();

    ClientGUI gui = new ClientGUI();

    public static void main(String[] args){
        new Client();
	}

	public boolean checkArrayList(ArrayList<String> al, String s){
        for (int i = 0; i < al.size(); i++){
            if (al.get(i).equals(s)){
                return false;
            }
        }
        return true;
    }

    public void printAllClients(ArrayList<String> al){
	    for (int i = 0; i < al.size(); i++){
            JOptionPane.showMessageDialog(null,al.get(i));
        }
    }


	public Client(){

        JFrame f = new JFrame("JAVA聊天室客户端");
        Container contentPane = f.getContentPane();
        JPanel pane = gui.init();
        f.getContentPane().add(pane);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(650,650);
        f.setVisible(true);
        try {
            //gui.Name.setText(name+CountClients.num);

            gui.Send.addActionListener(this);
            gui.Conn.addActionListener(this);
            gui.Dcon.addActionListener(this);
			socket=new Socket(ip,port);
			new Cthread().start();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket .getInputStream()));
			String msg1;
			while ((msg1 = br.readLine()) != null) {
				System.out.println(msg1);
				//欢迎来到xxx，现在有x人， xxx说xxx
                gui.addChartContent(msg1+"\n");

//                gui.addChartContent(new takeString().takeName(msg1));
//                gui.addChartContent(new takeString().takeNumber(msg1));
                if (checkArrayList(clients, new takeString().takeName(msg1))){
                    clients.add(new takeString().takeName(msg1));
                    gui.addOnLineMember(new takeString().takeName(msg1)+"\n");
                }
                gui.Name.setText(clients.get(0));
//                printAllClients(clients);


			}
		}
		catch (Exception e) {
		}
	}
	class Cthread extends Thread{
		public void run() {
			try {
				BufferedReader re = new BufferedReader(new InputStreamReader(getInputStreamFromString(gui.getInput())));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
//                JOptionPane.showMessageDialog(null,gui.Input.getText());

//				while (true) {
//                    LineContext = re.readLine();
//					pw.println	(LineContext);
//					gui.addChartContent(LineContext);
//				}
                if (new String(gui.getInput()).length()!=0){
                    LineContext=gui.getInput();
                    pw.println(LineContext);
                    gui.addChartContent(LineContext);
                }
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
    }



    //将stirng转换为inputstream
    public InputStream getInputStreamFromString(String str){
        InputStream in=new ByteArrayInputStream(str.getBytes());
        return in;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==gui.Send){
            //ta.append(ID.getText()+"\n");
            JOptionPane.showMessageDialog(null,CountClients.num);
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
            port = Integer.parseInt(gui.getPort());
            ip = gui.getIP();
            JOptionPane.showMessageDialog(null,"客户端已启动");
        }
    }


}
