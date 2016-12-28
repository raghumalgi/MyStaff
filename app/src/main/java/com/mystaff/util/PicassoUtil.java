package com.mystaff.util;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by raghavendra.malgi on 27-12-2016.
 */

public class PicassoUtil {

    public static void loadImage(Context context, String thumbnail, ImageView imageView){
        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.TRANSPARENT)
                .borderWidthDp(3)
                .cornerRadiusDp(30)
                .oval(false)
                .build();
        Picasso.with(context)
                .load(thumbnail)
                .resize(100, 100)
                .centerCrop()
                .transform(transformation)
                .into(imageView);

    }
}
