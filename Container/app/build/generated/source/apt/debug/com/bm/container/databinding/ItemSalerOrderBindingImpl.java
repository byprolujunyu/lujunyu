package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemSalerOrderBindingImpl extends ItemSalerOrderBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvOrderCode, 1);
        sViewsWithIds.put(R.id.state, 2);
        sViewsWithIds.put(R.id.pic, 3);
        sViewsWithIds.put(R.id.tvTitleName, 4);
        sViewsWithIds.put(R.id.tvName, 5);
        sViewsWithIds.put(R.id.name, 6);
        sViewsWithIds.put(R.id.count, 7);
        sViewsWithIds.put(R.id.location, 8);
        sViewsWithIds.put(R.id.tip, 9);
        sViewsWithIds.put(R.id.tvHintIsShow, 10);
        sViewsWithIds.put(R.id.piece, 11);
        sViewsWithIds.put(R.id.tvAggregatePrice, 12);
        sViewsWithIds.put(R.id.model_button, 13);
        sViewsWithIds.put(R.id.left_button, 14);
        sViewsWithIds.put(R.id.right_button, 15);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSalerOrderBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ItemSalerOrderBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[7]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[8]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[3]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[4]
            );
        this.item.setTag(null);
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