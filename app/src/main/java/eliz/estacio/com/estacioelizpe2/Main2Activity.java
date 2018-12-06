package eliz.estacio.com.estacioelizpe2;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private Button button;
    EditText eName, eAge, eGender;
    TextView tMsg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName = findViewById(R.id.etName);
        eAge = findViewById(R.id.etAge);
        eGender = findViewById(R.id.etGender);
        //tMsg = findViewById(R.id.tvMsg);

    }



    public void saveSP(View v) {
        SharedPreferences sp = getSharedPreferences("data1", Context.MODE_PRIVATE);
        SharedPreferences.Editor writer = sp.edit();
        String name = eName.getText().toString();
        String age = eAge.getText().toString();
        String gender = eGender.getText().toString();
        writer.putString("name", name);
        writer.putString("age", age);
        writer.putString("gender", gender);
        writer.commit();
        Toast.makeText(this, "data saved...", Toast.LENGTH_LONG).show();

    }
    public void displayMsg(View v){
        SharedPreferences sp = getSharedPreferences("data1",Context.MODE_PRIVATE);
        String name = sp.getString("name", String.valueOf(eName));
        String age = sp.getString("age", String.valueOf(eAge));
        String gender = sp.getString("gender", String.valueOf(eGender));
        String message = "Name:              " + name + "Age:          " + age + "Gender:          " + gender ;
        tMsg.setText(message);
    }

}
