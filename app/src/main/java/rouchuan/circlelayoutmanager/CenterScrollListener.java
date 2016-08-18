package rouchuan.circlelayoutmanager;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Dajavu on 16/8/18.
 */
public class CenterScrollListener extends RecyclerView.OnScrollListener{
    private boolean mAutoSet = false;

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if(!(layoutManager instanceof CircleLayoutManager)){
            mAutoSet = true;
            return;
        }

        final CircleLayoutManager circleLayoutManager = (CircleLayoutManager) layoutManager;
        if(!mAutoSet){
            if(newState == RecyclerView.SCROLL_STATE_IDLE){
                final int dx = circleLayoutManager.getOffsetCenterView();
                recyclerView.smoothScrollBy(dx,0);
            }
            mAutoSet = true;
        }
        if(newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING){
            mAutoSet = false;
        }
    }
}