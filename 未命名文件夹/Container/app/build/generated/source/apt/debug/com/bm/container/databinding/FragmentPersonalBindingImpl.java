package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentPersonalBindingImpl extends FragmentPersonalBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 1);
        sViewsWithIds.put(R.id.setting, 2);
        sViewsWithIds.put(R.id.title, 3);
        sViewsWithIds.put(R.id.change_info, 4);
        sViewsWithIds.put(R.id.model_face, 5);
        sViewsWithIds.put(R.id.face, 6);
        sViewsWithIds.put(R.id.type, 7);
        sViewsWithIds.put(R.id.model_bank, 8);
        sViewsWithIds.put(R.id.bank_name, 9);
        sViewsWithIds.put(R.id.bank, 10);
        sViewsWithIds.put(R.id.bank_id, 11);
        sViewsWithIds.put(R.id.tvFinishCount, 12);
        sViewsWithIds.put(R.id.tvCancelCount, 13);
        sViewsWithIds.put(R.id.name_title, 14);
        sViewsWithIds.put(R.id.name, 15);
        sViewsWithIds.put(R.id.phone, 16);
        sViewsWithIds.put(R.id.user_id, 17);
        sViewsWithIds.put(R.id.my_order, 18);
        sViewsWithIds.put(R.id.view_ovle, 19);
        sViewsWithIds.put(R.id.buyer_info, 20);
        sViewsWithIds.put(R.id.view_ovle_two, 21);
        sViewsWithIds.put(R.id.saler_order_model, 22);
        sViewsWithIds.put(R.id.saler_order, 23);
        sViewsWithIds.put(R.id.view_ovle_three, 24);
        sViewsWithIds.put(R.id.view_saler_order_model, 25);
        sViewsWithIds.put(R.id.saler_info, 26);
        sViewsWithIds.put(R.id.view_ovle_four, 27);
        sViewsWithIds.put(R.id.view_saler_info_model, 28);
        sViewsWithIds.put(R.id.my_posting, 29);
        sViewsWithIds.put(R.id.message, 30);
        sViewsWithIds.put(R.id.view_setting_message, 31);
        sViewsWithIds.put(R.id.feedback, 32);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentPersonalBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 33, sIncludes, sViewsWithIds));
    }
    private FragmentPersonalBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.ImageView) bindings[4]
            , (com.bm.container.view.CircleImageView) bindings[6]
            , (android.widget.LinearLayout) bindings[32]
            , (android.widget.LinearLayout) bindings[30]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.RelativeLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[29]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[16]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[17]
            , (android.view.View) bindings[19]
            , (android.view.View) bindings[27]
            , (android.view.View) bindings[24]
            , (android.view.View) bindings[21]
            , (android.view.View) bindings[28]
            , (android.view.View) bindings[25]
            , (android.view.View) bindings[31]
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
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}