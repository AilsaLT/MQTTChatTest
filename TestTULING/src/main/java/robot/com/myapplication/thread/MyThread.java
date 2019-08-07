package robot.com.myapplication.thread;

import android.content.Context;
import android.util.Log;

import robot.com.myapplication.mqtt.Constants;
import robot.com.myapplication.mqtt.SubscriptClient;
import robot.com.myapplication.pal.FriendsData;

/**
 * Created by Administrator on 2019/8/7.
 */

public class MyThread implements Runnable {
    public Context mContext;
    private static final String TAG = "MyThread";
    public MyThread(Context context) {
        this.mContext = context;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Log.i(TAG, "==============The client begin to start ....");
                SubscriptClient client = new SubscriptClient(mContext,
                        Constants.MQTT_LIGHT_SUBSCRIPT_CHAT_TOPIC,
                        Constants.MQTT_LIGHT_SUBSCRIPT_CHAT_clientid+ FriendsData.UserInfo.getUserName(),
                        Constants.MQTT_LIGHT_SUBSCRIPT_HOST);
                client.start();
                Log.i(TAG, "==============The client is running....");
                Thread.sleep(60000); // 每60秒联一下,10000 10秒
                if(client!=null) {
                    client = null;
                }
                Log.i(TAG, "==============The client is running....");
            }// end while
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "run: ==============重连失败....");
        }
    }
}
