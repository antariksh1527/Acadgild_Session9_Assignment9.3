package com.tech.gigabyte.customlistview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.attr.x;


public class Custom_ListView extends AppCompatActivity implements OnItemClickListener {


    //Called when activity is first created.

    ListView lview;
    ListViewAdapter lviewAdapter;

    //Creating Objects For Custom ListView TextView1
    private final static String name[] = {
            "   Antariksh", "   Rutika", "   Harsh",
            "   Anil", "   Ajit", "   Shubh",
            "   Ajay", "   Sourav", "   Ankesh",
            "   Akshay", "   Ramesh", "   Suresh",
            "   Prakash", "   Ashish", "   Robin"};


    //Creating Objects For Custom ListView TextView2
    private final static String number[] = {
            "   8879176986", "   8879176986", "   8879176986",
            "   8879176986", "   8879176986", "   8879176986",
            "   8879176986", "   8879176986", "   8879176986",
            "   8879176986", "   8879176986", "   8879176986",
            "   8879176986", "   8879176986", "   8879176986"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlv);

        //Set the activity content from a layout resource
        lview = (ListView) findViewById(R.id.lv);

        //Extending Baseadapter for custom listview
        lviewAdapter = new ListViewAdapter(this, name, number);

        //ready to accept output data
        System.out.println("adapter => " + lviewAdapter.getCount());

        //Setting the data behind this ListView
        lview.setAdapter(lviewAdapter);

        //The callback that will be invoked
        registerForContextMenu(lview);
    }

    //Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");             //Title of contextmenu
        menu.add(0, v.getId(), 0, "Call");                    //Menu (Context Menu)
        menu.add(0, v.getId(), 0, "Send SMS");
    }

    //Logic when item selected
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //Opening Dial Using Intent
        if (item.getTitle() == "Call") {
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+number));
            startActivity(i);

            //Opening Message when Send SMS Selected
        } else if (item.getTitle() == "Send SMS") {

            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:"));
            startActivity(sendIntent);
        } else {
            return false;
        }
        return true;

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}