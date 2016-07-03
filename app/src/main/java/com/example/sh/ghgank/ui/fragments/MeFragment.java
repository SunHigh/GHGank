package com.example.sh.ghgank.ui.fragments;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaBrowserCompat;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sh.ghgank.R;
import com.example.sh.ghgank.ui.activitys.LoginActivity;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UploadFileListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by sh on 2016/6/4.
 */
public class MeFragment extends Fragment implements View.OnClickListener{
    private Boolean isLogin = false;
    private CircleImageView img_Head;
    private TextView hint_Head;
    private EditText et_passWord;
    private EditText et_userName;
    private Boolean showPassword = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        img_Head = (CircleImageView) view.findViewById(R.id.img_head);
        hint_Head = (TextView) view.findViewById(R.id.text_head);
        et_userName = (EditText) view.findViewById(R.id.et_userName);
        et_passWord = (EditText) view.findViewById(R.id.et_passWord);
        img_Head.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_head:
                if (!isLogin){
                    initPopupWindow(v);
                    return;
                }else {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_PICK);
                    startActivityForResult(intent,1);
                }
                break;
        }
    }



    //显示popWindow
    private void initPopupWindow(View v) {
        View view = LayoutInflater.from(getActivity()).
                inflate(R.layout.pop_sign,null, false);
        Button btn_signIn = (Button) view.findViewById(R.id.btn_signin);
        Button btn_signUp = (Button) view.findViewById(R.id.btn_signup);
        et_passWord = (EditText) view.findViewById(R.id.et_passWord);
        final ImageButton img_lookPassword = (ImageButton) view.findViewById(R.id.img_lookpassword);
        //构建一个popWindow，参数依次是view，宽度，高度
        final PopupWindow popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //设置显示的动画效果
        popupWindow.setAnimationStyle(R.anim.anim_pop);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                //如果返回true,touch事件将被拦截
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0,350);


        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                popupWindow.dismiss();
            }
        });

        img_lookPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showPassword == false){
                    showPassword = true;
                    et_passWord.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    img_lookPassword.setBackgroundResource(R.mipmap.look);
                }else if(showPassword == true){
                    showPassword = false;
                    //必须在setInputType时设置两个属性才可以让EditText输入风格跟着改变
                    et_passWord.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    img_lookPassword.setBackgroundResource(R.mipmap.unlook);
                }

            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == getActivity().RESULT_OK && null != data){
            Uri uri = data.getData();
            String path = getImagePath(uri);
            ContentResolver cr = this.getActivity().getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                img_Head.setImageBitmap(bitmap);
                hint_Head.setVisibility(View.GONE);
                //调用bmobFile的上传方法
                final BmobFile bmobFile = new BmobFile(new File(path));
                bmobFile.uploadblock(getActivity(), new UploadFileListener() {
                    @Override
                    public void onSuccess() {}

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(getActivity(), "失败"+s, Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (FileNotFoundException e) {
                Log.e("SHTest", e.getMessage(), e);
            }

            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public String getImagePath(Uri uri) {
        String path = null;
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().getContentResolver().query(uri, filePathColumn,null, null, null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;

    }

}
