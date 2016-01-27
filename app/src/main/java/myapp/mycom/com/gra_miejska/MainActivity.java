package myapp.mycom.com.gra_miejska;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import static myapp.mycom.com.gra_miejska.json.GameList.updateGameList;


public class MainActivity extends ActionBarActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        updateGameList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new MenuFragment());

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, null);
        //fragmentTransaction.replace(R.id.container, new Fragment2(), null);
        //powinno sie uzywac replace zamiast add zeby byl widoczny ostatni fragment i aktywny.
        //kontener, fragment, nazwa transakcji
        //do animowania wjazdu fragmentu
        //fragmentTransaction.setCustomAnimations();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

  /*  @Override
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
    }*/

    public void exit() {
        finish();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 1) {
            exit();
        } else {
            getFragmentManager().popBackStack();
        }
    }


}
