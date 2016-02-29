package self.ashish.abc6;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,author,publication;
    String str1,str2,str3;
    Book book;
    MyDatabaseClass my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my=new MyDatabaseClass(this);
    }
    public void insertbook(View view){
        book=new Book();
        name=(EditText)findViewById(R.id.name);
        author=(EditText)findViewById(R.id.author);
        publication=(EditText)findViewById(R.id.publication);
        str1=name.getText().toString();
        str2=author.getText().toString();
        str3=publication.getText().toString();
        book.setName(str1);
        book.setAuthor(str2);
        book.setPublication(str3);
        my.insert(book);
    }
    public void display(View view){
        //Cursor cursor=my.display();
        Intent intent =new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
