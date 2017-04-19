package info.theel0ja.kouluruoka;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import java.util.Calendar;

/**
 * Created by theel0ja on 2.4.2017.
 */

// In this case, the fragment displays simple text based on the page
public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private String currentSchool;
    private Integer currentPage;
    private String backendURL;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        WebView mWebView = (WebView) view;

        if(mPage == 2) {
            currentSchool = "turku/ylakoulu"; // TODO: Get it from settings!
        }
        else {
            currentSchool = "turku/alakoulu";
        }

        if (BuildConfig.DEBUG) { // that will also used in "run", not only "debug" button in Android Studio
            backendURL = "viikon-kouluruoka.theel0ja.info";
        }
        else {
            backendURL = "viikon-kouluruoka.theel0ja.info"; // TODO: don't know if that's using it on signed .apk's or those that will go to google play... Let's see it...
        }

        /* http://stackoverflow.com/a/5574746/6451184 */
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);


        currentPage = 0;

        switch (day) {
            case Calendar.SATURDAY:
                currentPage = 1;
            case Calendar.SUNDAY:
                currentPage = 1;
        }

        // TODO: If saturday school, show current week (aka q=0)
        // TODO: If holiday, show next week (aka q=1)
        // TODO: ^ I think that the new API by Arkea Oy (aka viikon kouluruoka api 2.0) will being used here.

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        if(currentPage == 1) {
            fab.setImageResource(R.drawable.ic_arrow_back_white_24dp);
        }
        else {
            fab.setImageResource(R.drawable.ic_arrow_forward_white_24dp);
        }
        */



        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Use remote resource
        // 4.0.3 and up - Use https version
        // 4.0.3 and down - Use non-https version
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            mWebView.loadUrl("https://" + backendURL + "/" + currentSchool + "/?app&material&lang=" + java.util.Locale.getDefault().getLanguage() + "&q=" + currentPage + "&buttons=0");
            // TODO ^: when you get SampleFragmentPagerAdapter.java fixed, fix that "&buttons=0" to "&buttons=1" :)
        }
        else {
            mWebView.loadUrl("http://" + backendURL + "/" + currentSchool + "/?app&material&lang=" + java.util.Locale.getDefault().getLanguage() + "&q=" + currentPage + "&buttons=0");
            // TODO ^: when you get SampleFragmentPagerAdapter.java fixed, fix that "&buttons=0" to "&buttons=1" :)
        }

        return mWebView;
    }
}