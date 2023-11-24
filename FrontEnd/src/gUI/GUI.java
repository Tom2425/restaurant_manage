package gUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GUI {
    public static void main(String[] args) {
        try {
            // Gửi GET request
            URL getUrl = new URL("http://localhost:8080/api/data");
            HttpURLConnection getConn = (HttpURLConnection) getUrl.openConnection();
            getConn.setRequestMethod("GET");

            // Kiểm tra mã trạng thái
            int getResponseCode = getConn.getResponseCode();
            if (getResponseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader getReader = new BufferedReader(new InputStreamReader(getConn.getInputStream()));
                String getResponse = getReader.readLine();
                System.out.println(getResponse);
                getReader.close();
            } else {
                System.out.println("GET request failed. Response Code: " + getResponseCode);
            }

            // Gửi POST request
            URL postUrl = new URL("http://localhost:8080/api/update");
            HttpURLConnection postConn = (HttpURLConnection) postUrl.openConnection();
            postConn.setRequestMethod("POST");
            postConn.setDoOutput(true);

            // Gửi dữ liệu
            String newData = "New data to update";
            postConn.getOutputStream().write(newData.getBytes());

            // Kiểm tra mã trạng thái
            int postResponseCode = postConn.getResponseCode();
            if (postResponseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader postReader = new BufferedReader(new InputStreamReader(postConn.getInputStream()));
                String postResponse = postReader.readLine();
                System.out.println(postResponse);
                postReader.close();
            } else {
                System.out.println("POST request failed. Response Code: " + postResponseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

