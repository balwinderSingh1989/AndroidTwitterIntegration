package example.androidtwitter;

import example.androidtwitter.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends Activity {
	SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		saveAPItoSharePref();
		Fragment login = new LoginFragment();
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.content_frame, login);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.addToBackStack(null);
		ft.commit();

	}

	private void saveAPItoSharePref() {
		pref = getPreferences(0);
		SharedPreferences.Editor edit = pref.edit();
		edit.putString("CONSUMER_KEY", Config.API_KEY);
		edit.putString("CONSUMER_SECRET", Config.API_SECRET);
		edit.commit();
	}

}
