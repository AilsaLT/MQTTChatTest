package robot.com.myapplication.pal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import robot.com.myapplication.R;

public class RecActivity extends AppCompatActivity {
    private ImageView image_back;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_recommand);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        if ((FriendsData.myFriendList != null && FriendsData.myFriendList.size() >= 1) && (FriendsData.recomFriendList != null && FriendsData.recomFriendList.size() >= 1)){
            for (int i=0;i<FriendsData.myFriendList.size();i++){
                for (int j=0;j<FriendsData.recomFriendList.size();j++){
                    if (FriendsData.myFriendList.get( i ).getUserName().equals( FriendsData.recomFriendList.get( j ).getUserName() )){
                        FriendsData.recomFriendList.get( j ).setAgreeOrRefuse(1);
                    }
                }
            }
        }

        //将当前的用户从推荐好友中删除
        for (int i=0;i<FriendsData.recomFriendList.size();i++){
            if (FriendsData.recomFriendList.get(i).getUserName().equals(FriendsData.UserInfo.getUserName())){
                FriendsData.recomFriendList.remove(i);
            }
        }

        RecomFriendAdpater recomFriendAdpater = new RecomFriendAdpater(FriendsData.recomFriendList,RecActivity.this);
        mRecyclerView.setAdapter(recomFriendAdpater);
        recomFriendAdpater.notifyDataSetChanged();

        image_back = (ImageView) findViewById(R.id.image_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
