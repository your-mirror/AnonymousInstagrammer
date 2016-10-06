package com.dev.your_mirror.anonymousinstagrammer.view.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dev.your_mirror.anonymousinstagrammer.R;
import com.dev.your_mirror.anonymousinstagrammer.custom.glide.CircleTransform;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;

import java.util.List;

public class UserListAdapter extends ArrayAdapter<User> {
    CircleTransform circleTransform;

    private static class ViewHolder {
        ImageView avatar;
        TextView userName;
    }

    protected ViewHolder viewHolder;

    public UserListAdapter(Context context, List<User> users) {
        super(context, 0, users);
        circleTransform = new CircleTransform(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_search_user, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.search_user_avatar);
            viewHolder.userName = (TextView) convertView.findViewById(R.id.user_name);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User user = getItem(position);
        viewHolder.userName.setText(user.getUsername());

        Glide.with(getContext()).load(user.getProfilePicture()).transform(circleTransform)
            .into(viewHolder.avatar);

        return convertView;
    }
}
