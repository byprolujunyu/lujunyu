package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemCarBindingImpl extends ItemCarBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.car, 1);
        sViewsWithIds.put(R.id.delete, 2);
        sViewsWithIds.put(R.id.name, 3);
        sViewsWithIds.put(R.id.phone, 4);
        sViewsWithIds.put(R.id.number, 5);
        sViewsWithIds.put(R.id.textView3, 6);
        sViewsWithIds.put(R.id.time, 7);
        sViewsWithIds.put(R.id.textView4, 8);
        sViewsWithIds.put(R.id.carno, 9);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemCarBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ItemCarBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            , (android.widget.EditText) bindings[9]
            , (android.widget.TextView) bindings[2]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[4]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            );
        this.lllayout.setTag(null);
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