package com.example.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText yashwinInput;
    TextView yashwinText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yashwinInput = (EditText) findViewById(R.id.yashwinInput);
        yashwinText = (TextView) findViewById(R.id.yashwinText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }


//  Add a product to the databse
    public void addButtonClicked(View view){
        Products product = new Products(yashwinInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

//  Delete items
    public void deleteButtonClicked(View view){
        String inputText = yashwinInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        yashwinText.setText(dbString);
        yashwinInput.setText("");
    }
}
