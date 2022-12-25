package nn.radio.model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {
        ServerSocket server = new ServerSocket(3003);
        System.out.println("SplincodeTV_ObjectList_Transfer. Started: " + server);

        try {
            try {
                while (true) {
                    Socket socket = server.accept();
                    System.out.println("Connection accepted: " + socket);

                    Calculate calculate = new Calculate();

                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();

                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    ObjectInputStream ois = new ObjectInputStream(in);

                    DTO dtoIn = (DTO) ois.readObject();
                    System.out.println();
                    System.out.printf("Приняли клавишу с кодом dtoIn.keyCode: %s\n", dtoIn.keyCode);

                    DTO dtoOut = calculate.calcCoordinateByKeyEventPressed(dtoIn);

//                    try {
                    System.out.printf("отправляем в ответ угол поворота ... %s\n", dtoOut.A);
                    oos.writeObject(dtoOut);

//                    } finally {
//                        System.out.println("closing...");
//                        socket.close();
//                    }


                }
            } catch (EOFException e) {
                System.out.println(e);
                System.out.println("socket closing...");
//                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println("server closing...");
            server.close();
        }
    }

}