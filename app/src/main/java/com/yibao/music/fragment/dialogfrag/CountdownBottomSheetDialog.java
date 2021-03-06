package com.yibao.music.fragment.dialogfrag;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.yibao.music.R;
import com.yibao.music.model.CountdownBean;
import com.yibao.music.service.CountdownService;
import com.yibao.music.util.Constants;
import com.yibao.music.util.LogUtil;
import com.yibao.music.util.RxBus;
import com.yibao.music.util.ServiceUtil;
import com.yibao.music.util.StringUtil;
import com.yibao.music.view.WheelView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Des：${TODO}
 * Time:2017/8/22 14:11
 *
 * @author Stran
 */
public class CountdownBottomSheetDialog
        implements View.OnClickListener {
    private static final String ACTION_TIMER = "countdown";
    private final String[] arrTime = {"正在倒计时", "无", "15 分", "30 分", "1 小时", "1 小时 30 分", "2 小时"};
    private TextView mTvComplete;
    private TextView mTvCountdown;
    private WheelView mWheelView;
    private long mContdownTime = 0;
    private Disposable mDisposable;
    private Intent mTimerIntent;
    private Context mContext;
    private BottomSheetBehavior<View> mBehavior;

    public static CountdownBottomSheetDialog newInstance() {
        return new CountdownBottomSheetDialog();
    }

    public void getBottomDialog(Context context) {
        this.mContext = context;
        BottomSheetDialog dialog = new BottomSheetDialog(context);
        View view = LayoutInflater.from(context)
                .inflate(R.layout.countdown_dialog_fragment, null);
        initView(dialog, view);
        initListener();
        initRxData(dialog);
        initData();
        dialog.show();
    }

    private void initRxData(BottomSheetDialog dialog) {
        if (mDisposable == null) {
            mDisposable = RxBus.getInstance().toObserverable(CountdownBean.class)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(countdownBean -> {
                        String countdownTime = countdownBean.getCountdownTime();
                        String str = "剩余时间 " + countdownTime;
                        mTvCountdown.setText(str);
                        if (countdownTime.equals(Constants.FINISH_TIME)) {
                            dialog.dismiss();
                        }
                    });
        }
    }

    private void initData() {
        mTimerIntent = new Intent(mContext, CountdownService.class);
        mTimerIntent.setAction(ACTION_TIMER);
        List<String> timeList = new ArrayList<>(Arrays.asList(arrTime).subList(getServiceIsRunning() ? 0 : 1, arrTime.length - 1));
        setCompleteStata(!timeList.get(0).equals(arrTime[0]));
        mWheelView.setOffset(Constants.NUMBER_ONE);
        mWheelView.setItems(timeList);
    }

    private void initListener() {
        mTvComplete.setOnClickListener(this);
        mWheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String str) {
                mContdownTime = StringUtil.getSetCountdown(str);
                setCompleteStata(!str.equals(arrTime[0]));
            }
        });
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        if (vId == R.id.tv_time_complete) {
            if (mContdownTime > 0) {
                stopTimer();
                mTimerIntent.putExtra(Constants.COUNTDOWN_TIME, mContdownTime);
                mContext.startService(mTimerIntent);
            } else if (mContdownTime == 0) {
                stopTimer();
            }
        }
        mBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    private void stopTimer() {
        if (getServiceIsRunning()) {
            mContext.stopService(mTimerIntent);
        }
    }

    private void setCompleteStata(boolean b) {
        mTvComplete.setTextColor(mContext.getResources().getColor(b ? R.color.lyricsNormal : R.color.noClickText));
        mTvComplete.setEnabled(b);
    }

    private boolean getServiceIsRunning() {
        return ServiceUtil.isServiceRunning(mContext, Constants.TIME_SERVICE_NAME);
    }

    private void initView(BottomSheetDialog dialog, View view) {
        mTvComplete = view.findViewById(R.id.tv_time_complete);
        mTvCountdown = view.findViewById(R.id.tv_time_title);
        mWheelView = view.findViewById(R.id.wheel_view);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        dialog.setCanceledOnTouchOutside(true);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        dialog.setOnDismissListener(dialog12 -> {
            if (mDisposable != null) {
                mDisposable.dispose();
                mDisposable = null;
            }
        });
        view.findViewById(R.id.tv_time_cancel).setOnClickListener(this);
    }


}


