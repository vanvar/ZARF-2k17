package zarf2k17.cs2k18.zarf2k17;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by MSaqib on 09-04-2017.
 */

public class OurTeam extends AppCompatActivity {


    public String names[] = {"Shivani Shrotriya","Madiha Mariyam","Mohd. Shavez Khan","Mohd. Yaqzan","Mohd. Faisal Noor","Taha Waseem",
            "Mohd. Zubair","Anas Abdullah","Iffat Alam","Mohd. Amir Khan","Danish Khan"};

    public String post[] = {"Girl's Coordinator","Girl's Co-Coordinator","Cultural Coordinator","Cultural Co-Coordinator",
            "Literary Coordinator","Technical Coordinator","Technical Co-Coordinator",
            "Coordinator, Q.Incharge","Co-Coordinator, Q.Incharge","DC, Coordinator","P.R.O"};
    static ArrayList<Member> members = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i=0;i<11;i++){
            members.add(new Member(names[i],post[i],R.drawable.poster2));
        }
        setContentView(R.layout.ourteam);
        getSupportActionBar().setHomeButtonEnabled(true);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),1,false));
        myAdapter = new MyAdapter(OurTeam.this,members);
        recyclerView.setAdapter(myAdapter);

      //  makeSnack();
    }
    public void makeSnack(){

        //myAdapter.notifyDataSetChanged();
    }
}

