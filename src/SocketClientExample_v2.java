import java.io.*;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.*;
import java.net.URLEncoder;

public class SocketClientExample_v2 {
    public static int AGGREGATOR_PORT = 9876;

    //public static String serverAddress = "localhost";
    public static String serverAddress = "http://localhost:"+AGGREGATOR_PORT;



    public static void main(String[] args) {
        try {
            String payloadPOST = "{\"test_info_first_segment\":{\"Direction\":\"Downstream\",\"Command\":\"TCPBandwidth\", \"ReceiverIdentity\":\"Client\",\"SenderIdentity\":\"Observer\",\"SenderIPv4Address\":\"172.18.197.70\",\"ReceiverIPv4Address\":\"172.18.197.70\",\"Keyword\":\"prova insermento REST\", \"PackSize\":\"1420\",\"NumPack\":\"30\" },\"test_info_second_segment\":{\"Direction\":\"Downstream\",\"Command\":\"TCPBandwidth\", \"ReceiverIdentity\":\"Observer\",\"SenderIdentity\":\"Server\",\"SenderIPv4Address\":\"172.18.197.70\",\"ReceiverIPv4Address\":\"172.18.197.70\",\"Keyword\":\"prova insermento REST\", \"PackSize\":\"1420\",\"NumPack\":\"30\" },\"bandwidth_values_first_segment\": [{\"sub_id\":\"1\",\"nanoTimes\":\"39100\",\"kBytes\":\"1.38671875\"},{\"sub_id\":\"29\",\"nanoTimes\":\"2800\",\"kBytes\":\"1.38671875\"}],\"bandwidth_values_second_segment\": [{\"sub_id\":\"1\",\"nanoTimes\":\"97900\",\"kBytes\":\"1.38671875\"},{\"sub_id\":\"29\",\"nanoTimes\":\"3900\",\"kBytes\":\"1.38671875\"}]}";
            String serverURL = serverAddress;
            URL url = new URL(serverURL);
            System.out.println("connection to: " + url); 
            System.out.println("paylod post: " + payloadPOST); 
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println(url.toString());
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStream outst = connection.getOutputStream();
            ObjectOutputStream writer = new ObjectOutputStream(outst); 
            writer.writeObject(payloadPOST);
            writer.close();
            System.out.println("writer ended"); 
            InputStream inpst = connection.getInputStream();

            System.out.println("input stream get ok"); //

            InputStreamReader inpst1 = new InputStreamReader(inpst);
            System.out.println("input stream read get ok"); //

            BufferedReader br = new BufferedReader(inpst1);
            System.out.println("br ended"); //

//            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            System.out.println("json string init"); //d

            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            System.out.println(" br closed"); //

        //connection.disconnect();
            System.out.println("connection closed"); //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

