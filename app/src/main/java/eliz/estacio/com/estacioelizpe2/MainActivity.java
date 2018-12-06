package eliz.estacio.com.estacioelizpe2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button button;
    EditText eName, eAge, eGender;
    TextView tMsgName;
    TextView tMsgAge;
    TextView tMsgGender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName = findViewById(R.id.etName);
        eAge = findViewById(R.id.etAge);
        eGender = findViewById(R.id.etGender);
        tMsgName = findViewById(R.id.tvMsgName);
        tMsgAge = findViewById(R.id.tvMsgAge);
        tMsgGender = findViewById(R.id.tvMsgGender);

    }

    public void saveInternal(View v) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("details.txt", Context.MODE_PRIVATE);
            String name = eName.getText().toString();
            fos.write(name.getBytes());
            String age = eAge.getText().toString();
            fos.write(age.getBytes());
            String gender = eGender.getText().toString();
            fos.write(gender.getBytes());
            Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error writing data...", Toast.LENGTH_LONG).show();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayInternal(View v) {
        try {
            FileInputStream fin = openFileInput("details.txt");
            int c;
            StringBuffer buffer = new StringBuffer();
            while ((c = fin.read()) != -1) {
                buffer.append((char) c);
            }
            String message1 = "Good Day! " + "\n" + eName.getText().toString();
            tMsgName.setText(message1);
            String message2 = "Your age " + "\n" + eAge.getText().toString();;
            tMsgAge.setText(message2);
            String message3 = "Your Gender " + "\n" + eGender.getText().toString();;
            tMsgGender.setText(message3);
        } catch (Exception e) {
            Toast.makeText(this, "Error reading...", Toast.LENGTH_LONG).show();
        }

    }
}
