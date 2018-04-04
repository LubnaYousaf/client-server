import java.io.*;
import java.net.*;
public class TCPClient
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("127.0.0.1", 3000);
                               // reading from keyboard (keyRead object)
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                              // sending to client (pwrite object)
     OutputStream ostream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);
 
                              // receiving from server ( receiveRead  object)
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
     String receiveMessage, sendMessage;  
     boolean flag=true;             
     while(flag)
     {
        sendMessage = keyRead.readLine();  // keyboard reading
        pwrite.println(sendMessage);       // sending to server
        if(sendMessage.equals("bye"))  { 
        flag=false;
        pwrite.flush(); 
         sock.close();}
         else{                   // flush the data
        if((receiveMessage = receiveRead.readLine()) != null) //receive from server
        {
            System.out.println(receiveMessage); // displaying at DOS prompt
        } 
          
      }  
                 
    }    
    }  
