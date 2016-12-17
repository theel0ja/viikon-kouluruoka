package info.theel0ja.kouluruoka;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/* TODO: Add Attribution
   Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a>
 */

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        // Get version number
        String versionName = BuildConfig.VERSION_NAME;

        // Set version number
        TextView appName = (TextView) findViewById(R.id.version);
        appName.setText(getString(R.string.version) + versionName);
    }
    public void playStoreRateBtn(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=info.theel0ja.kouluruoka"));
        startActivity(intent);
    }
}
