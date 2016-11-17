package net.akira.bmi_application2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button calculate_BMI;

    private EditText height;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText)findViewById(R.id.height_edit);
        weight = (EditText)findViewById(R.id.weight_edit);

        calculate_BMI = (Button)findViewById(R.id.compute_button);

        calculate_BMI.setOnClickListener(this);
    }



    public void BMI(String s_height, String s_weight){
        double height = Double.valueOf(s_height);
        double weight = Double.valueOf(s_weight);

        double bmi;
        if((height/100) >= 1 ){
            bmi = weight/(height * height);
        }
        else{
            height = height/100;
            bmi = weight/(height * height);
        }
        TextView result = (TextView)findViewById(R.id.resault_text);
        result.setText("BMI指數：");
        Intent intent_main = new Intent(MainActivity.this, ResultActivity.class);
        intent_main.putExtra("date", result.getText());
        intent_main.putExtra("BMI", bmi);

        startActivity(intent_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.compute_button:
                BMI(height.getText().toString(), weight.getText().toString());
                break;
        }
    }
}
