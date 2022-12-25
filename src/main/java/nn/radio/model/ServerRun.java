package nn.radio.model;

import static java.lang.Thread.sleep;

public class ServerRun {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.run();

    }
}
