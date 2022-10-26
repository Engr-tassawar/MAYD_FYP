package adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fragments.customer_cancelled_fragment;
import fragments.customer_completed_fragment;
import fragments.customer_on_going_fragment;

public class customer_viewPager_adapter extends FragmentPagerAdapter {
    public customer_viewPager_adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new customer_on_going_fragment();
            case 1:return new customer_completed_fragment();
            case 2:return new customer_cancelled_fragment();
            default:return new customer_on_going_fragment();

        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
            title="On-Going";
        }
        else if (position==1) {
            title = "Completed";
        }
        else  {
            title = "Cancelled";
        }
        return title;
    }
}
