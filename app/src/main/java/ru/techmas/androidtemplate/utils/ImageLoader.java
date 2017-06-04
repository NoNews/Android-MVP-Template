package ru.techmas.androidtemplate.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Date: 04.06.2017
 * Time: 11:35
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class ImageLoader {

    //@formatter:off
    private ImageLoader(){}
    //@formatter:on


    public static void load(Context context, ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .into(imageView);
        // TODO: 04.06.2017 PlaceHolder here and any logic
        
    }

}
