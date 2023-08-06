package gptcode;
import javax.swing.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import gptcode.themes.MyFlatLaf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.*;
 

public class SwingUI extends JFrame {
    private JTextField textField;
    private JButton uploadButton;
    private JButton sendButton;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    private List<String> systemStr = new ArrayList<>();
    private List<String> userStr = new ArrayList<>();

    private static final String API_KEY = "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";
    private OkHttpClient client;

    public SwingUI() {
        setTitle("Swing ChatGpt");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        textField = new JTextField(20);
        uploadButton = new JButton("File");
        sendButton = new JButton("Enter");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(textField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        topPanel.add(uploadButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        topPanel.add(sendButton, gbc);

        textArea = new JTextArea(30, 50);
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setLineWrap(true);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String response = sendQuestionToOpenAI(textField.getText());
                    textArea.setText(response);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //엔터키를 입력하면, 자동으로 문장이 입력되도록 하는 부분.
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendButton.doClick();
            }
        });
         client = new OkHttpClient.Builder()
    .connectTimeout(120, TimeUnit.SECONDS)
    .writeTimeout(120, TimeUnit.SECONDS)
    .readTimeout(120, TimeUnit.SECONDS)
    .build();

        setBounds(100, 100, 450, 300);
        setVisible(true);
    }

    public String sendQuestionToOpenAI(String question) throws IOException, NullPointerException {

        
        if(systemStr ==null || systemStr.size()==0){
            systemStr.add("You are a helpful assistant.");
            userStr.add(question);
        }
        
        
        StringBuilder messages = new StringBuilder();
        for(int i=0; i<systemStr.size(); i++){
            messages.append("{\"role\": \"system\", \"content\": \""+systemStr.get(i)+"\"},");
            messages.append("{\"role\": \"user\", \"content\": \""+userStr.get(i)+"\"},");
            System.out.println(systemStr.get(i)+" "+ i+ " \n");
            System.out.println(userStr.get(i)+" "+ i + "\n");
        }
        // 마지막 쉼표 제거
        if (messages.length() > 0) {
            messages.deleteCharAt(messages.length() - 1);
        }

        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        String json = "{"
                  + "\"model\": \"gpt-3.5-turbo-16k\","
                + "\"messages\": ["
                + messages.toString() 
                + "]"
                + "}";

        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
          
              JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(responseBody);
            JsonObject obj = element.getAsJsonObject();
            String content = null;
            if( obj.getAsJsonArray("choices")!=null){
            JsonArray choices = obj.getAsJsonArray("choices");
            JsonObject choice = choices.get(0).getAsJsonObject();
            JsonObject message = choice.getAsJsonObject("message");
             content = message.get("content").getAsString();
            userStr.add(question);
            systemStr.add(content);
            }else{
                 //userStr.add(question);
            //systemStr.add("no response");
            System.out.println("no response");
            }
            if(content ==null){
                content = "no response";
            }
            return content+"\n";
        }
       
    }

    public static void main(String[] args) {
        MyFlatLaf.setup();
        new SwingUI();
    }
}
