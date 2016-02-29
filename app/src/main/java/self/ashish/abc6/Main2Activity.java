package self.ashish.abc6;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        MyDatabaseClass my=new MyDatabaseClass(this);
        Cursor cursor=my.display();
        if (cursor.moveToFirst()){
            do {
                String name=cursor.getString(cursor.getColumnIndex("NAME"));
                String author=cursor.getString(cursor.getColumnIndex("AUTHOR"));
                String publication=cursor.getString(cursor.getColumnIndex("PUBLICATION"));
                Toast.makeText(Main2Activity.this,name+author+publication, Toast.LENGTH_SHORT).show();
            }while (cursor.moveToNext());

            String[] from=new String[]{"NAME","AUTHOR","PUBLICATION"};

            int[] to=new int[]{R.id.textView,R.id.textView2,R.id.textView3};

            SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.cellitem,cursor,from,to);

            ListView view=(ListView) findViewById(R.id.listView);
            
            view.setAdapter(adapter);
        }
    }

}
