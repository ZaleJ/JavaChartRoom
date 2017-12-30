import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Server{

	int port;				//端口号
	List<Socket> clients;	//客户端列表，包含所有连接到该客户端的信息
	ServerSocket server;	//服务器
    static ServerGUI gui = new ServerGUI();

	public static void main(String[] args){
        JFrame f = new JFrame("JAVA聊天室服务器");
        Container contentPane = f.getContentPane();
        JPanel pane = gui.init();
        f.getContentPane().add(pane);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(600,500);
        f.setVisible(true);

		new Server();
	}	//main函数，创建服务器

    //服务器实现
	public Server(){
		try{
			port=6666;      //定义具体端口号端口
			clients = new ArrayList<Socket>();	//定义客户端列表，包含客户所有信息
			server = new ServerSocket(port);	//定义服务器对象

			//死循环检测有无新客户端连接
			while(true){
				Socket socket=server.accept();
				//当检测到有客户端加入时候，将客户端信息加入列表，并创建一个新的关于刚进入的客户端的MyThread线程
				clients.add(socket);
				gui.OnlineNum++;
				gui.lblOnlineNum.setText("当前在线人数："+gui.OnlineNum);
				String clientName = "client"+gui.OnlineNum;
				Mythread mythread=new Mythread(socket, clientName);
				mythread.start();
			}
		}catch(Exception ex){}
	}

	//每次检测到有客户端加入，就创建一个MyThread线程在服务器端显示所有客户端的聊天内容
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
				//msg = "欢迎【" + ssocket.getInetAddress() + "】进入聊天室！当前聊天室有【" + clients.size() + "】人";


                msg = "欢迎【" + Name + "】进入聊天室！当前聊天室有【" + clients.size() + "】人";
				sendMsg();
				while ((msg = br.readLine()) != null) {
					msg = "【" + Name + "】说sasasa：" + msg;
					sendMsg(); 
				}
			}
			catch(Exception ex){
			}
		}

		//对自己和所有客户端发送一条消息
		public void sendMsg(){
			try{
                //对自己发送一条消息
				System.out.println(msg);

                //对所有客户端发送一条消息
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