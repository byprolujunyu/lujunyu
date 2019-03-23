package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemMarketBindingImpl extends ItemMarketBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.item, 1);
        sViewsWithIds.put(R.id.pic, 2);
        sViewsWithIds.put(R.id.state, 3);
        sViewsWithIds.put(R.id.llTitle, 4);
        sViewsWithIds.put(R.id.tvTitleName, 5);
        sViewsWithIds.put(R.id.type, 6);
        sViewsWithIds.put(R.id.ll_xiang_status, 7);
        sViewsWithIds.put(R.id.xiang_status, 8);
        sViewsWithIds.put(R.id.ll_price_value, 9);
        sViewsWithIds.put(R.id.name, 10);
        sViewsWithIds.put(R.id.value, 11);
        sViewsWithIds.put(R.id.tv_type, 12);
        sViewsWithIds.put(R.id.ll_value_sale_num, 13);
        sViewsWithIds.put(R.id.name_sale_num, 14);
        sViewsWithIds.put(R.id.value_sale_num, 15);
        sViewsWithIds.put(R.id.location, 16);
        sViewsWithIds.put(R.id.people, 17);
        sViewsWithIds.put(R.id.ll_status, 18);
        sViewsWithIds.put(R.id.tv_status, 19);
        sViewsWithIds.put(R.id.tip, 20);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemMarketBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private ItemMarketBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[17]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[8]
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