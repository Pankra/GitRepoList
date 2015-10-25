package com.pankra.gitrepolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;


/**
 * An activity representing a list of Users. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link UserDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link UserListFragment} and the item details
 * (if present) is a {@link UserDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link UserListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class UserListActivity extends FragmentActivity
        implements UserListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
//    private UserAdapter userAdapter;
    private LayoutInflater vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);


        if (findViewById(R.id.user_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((UserListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.user_list))
                    .setActivateOnItemClick(true);
        }
//        vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // TODO: If exposing deep links into your app, handle intents here.
    }



//    public UserAdapter getUserAdapter(ArrayList<User> users) {
//        if (userAdapter == null) {
//            userAdapter = new UserAdapter(this, R.layout.user_list_single, users);
//        }
//        return userAdapter;
//    }

    /**
     * Callback method from {@link UserListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(UserDetailFragment.ARG_ITEM_ID, id);
            UserDetailFragment fragment = new UserDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.user_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, UserDetailActivity.class);
            detailIntent.putExtra(UserDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

//    public class UserAdapter extends ArrayAdapter<User> {
//        private List<User> users;
//
//        public UserAdapter(Context context, int textViewResourceId, List<User> users) {
//            super(context, textViewResourceId, users);
//            this.users = users;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View v = convertView;
//            if (v == null) {
//                vi = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//                v = vi.inflate(R.layout.user_list_single, null);
//            }
//            User u = users.get(position);
//            if (u != null) {
//                ImageView iv = (ImageView) v.findViewById(R.id.img);
//                if (iv != null) {
//                    Glide.with(getContext()).load(u.getAvatar_url()).override(50,50).into(iv);
//                }
//            }
//            return v;
//        }
//    }

}
