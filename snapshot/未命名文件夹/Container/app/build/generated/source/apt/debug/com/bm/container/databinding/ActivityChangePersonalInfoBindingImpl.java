package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityChangePersonalInfoBindingImpl extends ActivityChangePersonalInfoBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(19);
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {1},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 2);
        sViewsWithIds.put(R.id.face, 3);
        sViewsWithIds.put(R.id.name, 4);
        sViewsWithIds.put(R.id.address, 5);
        sViewsWithIds.put(R.id.model_contack, 6);
        sViewsWithIds.put(R.id.weixin, 7);
        sViewsWithIds.put(R.id.qq, 8);
        sViewsWithIds.put(R.id.checkbox, 9);
        sViewsWithIds.put(R.id.model_bank, 10);
        sViewsWithIds.put(R.id.bank_name, 11);
        sViewsWithIds.put(R.id.bank, 12);
        sViewsWithIds.put(R.id.bank_id, 13);
        sViewsWithIds.put(R.id.delete, 14);
        sViewsWithIds.put(R.id.add, 15);
        sViewsWithIds.put(R.id.gridview, 16);
        sViewsWithIds.put(R.id.choose_city_tip, 17);
        sViewsWithIds.put(R.id.register, 18);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChangePersonalInfoBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityChangePersonalInfoBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[15]
            , (android.widget.EditText) bindings[5]
            , (android.widget.TextView) bindings[12]
            , (com.bm.container.view.XEditText) bindings[13]
            , (android.widget.EditText) bindings[11]
            , (android.widget.CheckBox) bindings[9]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[14]
            , (com.bm.container.view.CircleImageView) bindings[3]
            , (com.bm.container.view.ExtraGridView) bindings[16]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[8]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[2]
            , (android.widget.Button) bindings[18]
            , (com.bm.container.databinding.TopbarBinding) bindings[1]
            , (android.widget.EditText) bindings[7]
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
                return onChangeTopbar((com.bm.container.databinding.TopbarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeTopbar(com.bm.container.databinding.TopbarBinding Topbar, int fieldId) {
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