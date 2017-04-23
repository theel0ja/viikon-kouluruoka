package info.theel0ja.kouluruoka;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.content.res.Resources;

/**
 * Created by theel0ja on 2.4.2017.
 */

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    final int PAGE_COUNT = 2;

    //private String primary_schools = Resources.getSystem().getString(R.string.elementary_school);
    //private String secondary_schools = Resources.getSystem().getString(R.string.secondary_school);
    private String primary_schools = "Elementary schools";

    private String secondary_schools = "Secondary schools";
    // TODO ^: FIX TRANSLATIONS

    private String tabTitles[] = new String[] { primary_schools , secondary_schools };

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}