package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityChangeCompanyInfoBindingImpl extends ActivityChangeCompanyInfoBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(18);
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {1},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 2);
        sViewsWithIds.put(R.id.face, 3);
        sViewsWithIds.put(R.id.name, 4);
        sViewsWithIds.put(R.id.phone, 5);
        sViewsWithIds.put(R.id.address, 6);
        sViewsWithIds.put(R.id.person, 7);
        sViewsWithIds.put(R.id.checkbox, 8);
        sViewsWithIds.put(R.id.model_bank, 9);
        sViewsWithIds.put(R.id.bank_name, 10);
        sViewsWithIds.put(R.id.bank, 11);
        sViewsWithIds.put(R.id.bank_id, 12);
        sViewsWithIds.put(R.id.delete, 13);
        sViewsWithIds.put(R.id.add, 14);
        sViewsWithIds.put(R.id.gridview, 15);
        sViewsWithIds.put(R.id.choose_city_tip, 16);
        sViewsWithIds.put(R.id.register, 17);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChangeCompanyInfoBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityChangeCompanyInfoBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[14]
            , (android.widget.EditText) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (com.bm.container.view.XEditText) bindings[12]
            , (android.widget.EditText) bindings[10]
            , (android.widget.CheckBox) bindings[8]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[13]
            , (com.bm.container.view.CircleImageView) bindings[3]
            , (com.bm.container.view.ExtraGridView) bindings[15]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[5]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[2]
            , (android.widget.Button) bindings[17]
            , (com.bm.container.databinding.TopbarBinding) bindings[1]
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