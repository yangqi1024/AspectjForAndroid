package com.example.gsz.buriedpoint;

import android.view.View;

/**
 * Description ...
 *
 * @author gsz
 * @create 2017/11/2
 * @since V1.1.2
 */
public interface SingleClickListener extends View.OnClickListener {
    @BuryPoint
    @Override
    void onClick(View v);

}
