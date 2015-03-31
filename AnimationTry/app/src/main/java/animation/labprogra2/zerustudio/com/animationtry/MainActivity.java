package animation.labprogra2.zerustudio.com.animationtry;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.EventListener;


public class MainActivity extends ActionBarActivity {

    ImageView image_stev;
    AnimationDrawable frameAnimation;
    ToggleButton animar, tween, both;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_stev = (ImageView)findViewById(R.id.image);
        animar = (ToggleButton)findViewById(R.id.animar);
        tween = (ToggleButton)findViewById(R.id.tweenAnim);
        both = (ToggleButton)findViewById(R.id.bothAnim);

        image_stev.setBackgroundResource(R.drawable.stev_drawable);

        frameAnimation = (AnimationDrawable) image_stev.getBackground();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clicked(View view) {
        if(animar.isChecked()) {
            frameAnimation.start();
        }else{
            frameAnimation.stop();
        }
    }

    public void tweenAnim(View view) {
        if(tween.isChecked()) {
            Animation translate = AnimationUtils.loadAnimation(this, R.anim.move_landscape_animation);
            image_stev.setAnimation(translate);
        }
    }

    public void bothAnim(View view) {
        if(both.isChecked()) {
            frameAnimation.start();
            Animation translate = AnimationUtils.loadAnimation(this, R.anim.move_landscape_animation);
            image_stev.setAnimation(translate);
        }else{
            frameAnimation.stop();
        }
    }
}
