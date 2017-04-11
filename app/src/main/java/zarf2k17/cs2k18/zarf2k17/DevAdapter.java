package zarf2k17.cs2k18.zarf2k17;

/**
 * Created by MSaqib on 12-04-2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DevAdapter extends RecyclerView.Adapter<DevAdapter.MyViewHolder> {

    private static final int DURATION = 250;
    Context context;
    ArrayList<Developer> developers;
    LayoutInflater inflater;

    public DevAdapter(Context context, ArrayList<Developer> developers) {

        this.context = context;
        this.developers = developers;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View view = inflater.inflate(R.layout.developer, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {
        myViewHolder.name.setText(developers.get(position).name);
        myViewHolder.facebook_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, developers.get(position).name + " FACEBOOK", Toast.LENGTH_SHORT).show();
            }
        });

        myViewHolder.github_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, developers.get(position).name + " GITHUB", Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myViewHolder.linearLayoutDetails.getVisibility() == View.GONE) {
                    ExpandAndCollapseView.expand(myViewHolder.linearLayoutDetails, DURATION);
                    myViewHolder.imageViewExpand.setImageResource(R.mipmap.more);
                    //rotate(-180.0f);
                    Animation animation = new RotateAnimation(0.0f, -180.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setFillAfter(true);
                    animation.setDuration(DURATION);
                    myViewHolder.imageViewExpand.startAnimation(animation);
                } else {
                    ExpandAndCollapseView.collapse(myViewHolder.linearLayoutDetails, DURATION);
                    myViewHolder.imageViewExpand.setImageResource(R.mipmap.less);
                    // rotate(180.0f);
                    Animation animation = new RotateAnimation(0.0f, 180.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setFillAfter(true);
                    animation.setDuration(DURATION);
                    myViewHolder.imageViewExpand.startAnimation(animation);
                }
            }
        });
    }

    private void rotate(float angle) {

    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;
        ImageView imageViewExpand;
        ViewGroup linearLayoutDetails;
        LinearLayout linearLayout;
        ImageView facebook_button;
        ImageView github_button;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.dev_name);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayoutDetails = (ViewGroup) itemView.findViewById(R.id.linearLayoutDetails);
            imageViewExpand = (ImageView) itemView.findViewById(R.id.imageViewExpand);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.toggler_layout);
            facebook_button = (ImageView) itemView.findViewById(R.id.dev_facebook);
            github_button = (ImageView) itemView.findViewById(R.id.dev_github);
        }
    }
}
