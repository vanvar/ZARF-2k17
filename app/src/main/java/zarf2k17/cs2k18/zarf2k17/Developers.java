package zarf2k17.cs2k18.zarf2k17;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Developers extends AppCompatActivity {

    public ArrayList<Developer> developers = new ArrayList<>();
    public RecyclerView recyclerView;
    public DevAdapter devAdapter;
    private String dev_names[] = {"Mohammad Saqib", "Hashir Ahmed", "Vanshika Varshney", "Aman Varshney"};
    private int images_id[] = {R.drawable.hash2};
    private String facebook_url[] = {"FACEBOOK"};
    private String github_url[] = {"GITHUB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        for (int i = 0; i < 4; i++)
            developers.add(new Developer(dev_names[i], images_id[0], facebook_url[0], github_url[0]));

        recyclerView = (RecyclerView) findViewById(R.id.developer_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
        devAdapter = new DevAdapter(Developers.this, developers);
        recyclerView.setAdapter(devAdapter);
    }
}