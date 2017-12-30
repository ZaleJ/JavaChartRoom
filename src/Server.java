import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Server{

	int port;				//�˿ں�
	List<Socket> clients;	//�ͻ����б������������ӵ��ÿͻ��˵���Ϣ
	ServerSocket server;	//������
    static ServerGUI gui = new ServerGUI();

	public static void main(String[] args){
        JFrame f = new JFrame("JAVA�����ҷ�����");
        Container contentPane = f.getContentPane();
        JPanel pane = gui.init();
        f.getContentPane().add(pane);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(600,500);
        f.setVisible(true);

		new Server();
	}	//main����������������

    //������ʵ��
	public Server(){
		try{
			port=6666;      //�������˿ںŶ˿�
			clients = new ArrayList<Socket>();	//����ͻ����б������ͻ�������Ϣ
			server = new ServerSocket(port);	//�������������

			//��ѭ����������¿ͻ�������
			while(true){
				Socket socket=server.accept();
				//����⵽�пͻ��˼���ʱ�򣬽��ͻ�����Ϣ�����б�������һ���µĹ��ڸս���Ŀͻ��˵�MyThread�߳�
				clients.add(socket);
				gui.OnlineNum++;
				gui.lblOnlineNum.setText("��ǰ����������"+gui.OnlineNum);
				String clientName = "client"+gui.OnlineNum;
				Mythread mythread=new Mythread(socket, clientName);
				mythread.start();
			}
		}catch(Exception ex){}
	}

	//ÿ�μ�⵽�пͻ��˼��룬�ʹ���һ��MyThread�߳��ڷ���������ʾ���пͻ��˵���������
	class Mythread extends Thread{
		Socket ssocket;
		private BufferedReader br; 
		private PrintWriter pw; 
		public String msg;
		String Name;
		public Mythread(Socket s, String n){
			ssocket=s;
			Name=n;
		}
		public void run(){
			try{
				br = new BufferedReader(new InputStreamReader(ssocket.getInputStream())); 
				//msg = "��ӭ��" + ssocket.getInetAddress() + "�����������ң���ǰ�������С�" + clients.size() + "����";


                msg = "��ӭ��" + Name + "�����������ң���ǰ�������С�" + clients.size() + "����";
				sendMsg();
				while ((msg = br.readLine()) != null) {
					msg = "��" + Name + "��˵sasasa��" + msg;
					sendMsg(); 
				}
			}
			catch(Exception ex){
			}
		}

		//���Լ������пͻ��˷���һ����Ϣ
		public void sendMsg(){
			try{
                //���Լ�����һ����Ϣ
				System.out.println(msg);

                //�����пͻ��˷���һ����Ϣ
				for(int i = clients.size() - 1; i >= 0; i--){
					pw=new PrintWriter(clients.get(i).getOutputStream(),true);
					pw.println(msg);
					pw.flush();

				}
			}
			catch(Exception ex){}
		}
	}
}