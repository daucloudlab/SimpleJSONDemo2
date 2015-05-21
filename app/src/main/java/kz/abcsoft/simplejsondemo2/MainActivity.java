package kz.abcsoft.simplejsondemo2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView)findViewById(R.id.listView1) ;

        String strJSON = "[{\"MemberID\":\"1\",\"Name\":\"Мурзик\",\"Tel\":\"4954876107\"}"
                + ",{\"MemberID\":\"2\",\"Name\":\"Барсик\",\"Tel\":\"4954780121\"}"
                + ",{\"MemberID\":\"3\",\"Name\":\"Рыжик\",\"Tel\":\"4954543211\"}]";
        try{
            JSONArray data = new JSONArray(strJSON) ;

            ArrayList<Map<String, String>> MyArrList = new ArrayList<Map<String, String>>() ;
            HashMap<String, String> map ;

            for(int i = 0; i < data.length(); i++){
                JSONObject c = data.getJSONObject(i) ;
                map = new HashMap<String, String>() ;
                map.put("MemberID", c.getString("MemberID")) ;
                map.put("Name", c.getString("Name")) ;
                map.put("Tel", c.getString("Tel")) ;
                MyArrList.add(map) ;
            }

            SimpleAdapter simpleAdapter ;
            simpleAdapter = new SimpleAdapter(MainActivity.this, MyArrList, R.layout.three_column,
                    new String[]{"MemberID", "Name", "Tel"},
                    new int[]{R.id.ColMemberID, R.id.ColName, R.id.ColTel}) ;
            listview.setAdapter(simpleAdapter);
        }catch (JSONException e){
            e.printStackTrace();
        }
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
}
