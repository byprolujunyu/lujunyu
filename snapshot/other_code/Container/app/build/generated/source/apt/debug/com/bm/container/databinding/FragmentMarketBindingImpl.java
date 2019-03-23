package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentMarketBindingImpl extends FragmentMarketBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(24);
        sIncludes.setIncludes(0, 
            new String[] {"topbar_search"},
            new int[] {1},
            new int[] {R.layout.topbar_search});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tab_buy, 2);
        sViewsWithIds.put(R.id.tv_one, 3);
        sViewsWithIds.put(R.id.view_one, 4);
        sViewsWithIds.put(R.id.tab_sale, 5);
        sViewsWithIds.put(R.id.tv_two, 6);
        sViewsWithIds.put(R.id.view_two, 7);
        sViewsWithIds.put(R.id.chooose_city, 8);
        sViewsWithIds.put(R.id.city, 9);
        sViewsWithIds.put(R.id.city_direction, 10);
        sViewsWithIds.put(R.id.chooose_type, 11);
        sViewsWithIds.put(R.id.type, 12);
        sViewsWithIds.put(R.id.type_direction, 13);
        sViewsWithIds.put(R.id.chooose_status, 14);
        sViewsWithIds.put(R.id.tv_status, 15);
        sViewsWithIds.put(R.id.type_status, 16);
        sViewsWithIds.put(R.id.chooose_money, 17);
        sViewsWithIds.put(R.id.money, 18);
        sViewsWithIds.put(R.id.money_direction, 19);
        sViewsWithIds.put(R.id.refresh, 20);
        sViewsWithIds.put(R.id.list, 21);
        sViewsWithIds.put(R.id.float_model, 22);
        sViewsWithIds.put(R.id.float_button_tip, 23);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMarketBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private FragmentMarketBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.RelativeLayout) bindings[17]
            , (android.widget.RelativeLayout) bindings[14]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.TextView) bindings[23]
            , (android.widget.RelativeLayout) bindings[22]
            , (android.support.v7.widget.RecyclerView) bindings[21]
            , (android.widget.TextView) bindings[18]
            , (android.widget.ImageView) bindings[19]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[5]
            , (com.bm.container.databinding.TopbarSearchBinding) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[16]
            , (android.view.View) bindings[4]
            , (android.view.View) bindings[7]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        topbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (topbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        topbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeTopbar((com.bm.container.databinding.TopbarSearchBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeTopbar(com.bm.container.databinding.TopbarSearchBinding Topbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(topbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): topbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}