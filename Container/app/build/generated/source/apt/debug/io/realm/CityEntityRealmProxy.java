package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CityEntityRealmProxy extends com.bm.container.module.base.Entity.CityEntity
    implements RealmObjectProxy, CityEntityRealmProxyInterface {

    static final class CityEntityColumnInfo extends ColumnInfo
        implements Cloneable {

        public long firstWordIndex;
        public long idIndex;
        public long cityNameIndex;
        public long provinceIndex;
        public long clickIndex;

        CityEntityColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.firstWordIndex = getValidColumnIndex(path, table, "CityEntity", "firstWord");
            indicesMap.put("firstWord", this.firstWordIndex);
            this.idIndex = getValidColumnIndex(path, table, "CityEntity", "id");
            indicesMap.put("id", this.idIndex);
            this.cityNameIndex = getValidColumnIndex(path, table, "CityEntity", "cityName");
            indicesMap.put("cityName", this.cityNameIndex);
            this.provinceIndex = getValidColumnIndex(path, table, "CityEntity", "province");
            indicesMap.put("province", this.provinceIndex);
            this.clickIndex = getValidColumnIndex(path, table, "CityEntity", "click");
            indicesMap.put("click", this.clickIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CityEntityColumnInfo otherInfo = (CityEntityColumnInfo) other;
            this.firstWordIndex = otherInfo.firstWordIndex;
            this.idIndex = otherInfo.idIndex;
            this.cityNameIndex = otherInfo.cityNameIndex;
            this.provinceIndex = otherInfo.provinceIndex;
            this.clickIndex = otherInfo.clickIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CityEntityColumnInfo clone() {
            return (CityEntityColumnInfo) super.clone();
        }

    }
    private CityEntityColumnInfo columnInfo;
    private ProxyState<com.bm.container.module.base.Entity.CityEntity> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("firstWord");
        fieldNames.add("id");
        fieldNames.add("cityName");
        fieldNames.add("province");
        fieldNames.add("click");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CityEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CityEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.bm.container.module.base.Entity.CityEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$firstWord() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.firstWordIndex);
    }

    public void realmSet$firstWord(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.firstWordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.firstWordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.firstWordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.firstWordIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$cityName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cityNameIndex);
    }

    public void realmSet$cityName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cityNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cityNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cityNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cityNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$province() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.provinceIndex);
    }

    public void realmSet$province(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.provinceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.provinceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.provinceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.provinceIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$click() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.clickIndex);
    }

    public void realmSet$click(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.clickIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.clickIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CityEntity")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CityEntity");
            realmObjectSchema.add(new Property("firstWord", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cityName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("province", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("click", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("CityEntity");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CityEntity")) {
            Table table = sharedRealm.getTable("class_CityEntity");
            table.addColumn(RealmFieldType.STRING, "firstWord", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cityName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "province", Table.NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "click", Table.NOT_NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_CityEntity");
    }

    public static CityEntityColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CityEntity")) {
            Table table = sharedRealm.getTable("class_CityEntity");
            final long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CityEntityColumnInfo columnInfo = new CityEntityColumnInfo(sharedRealm.getPath(), table);

            if (table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
            }

            if (!columnTypes.containsKey("firstWord")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'firstWord' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("firstWord") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'firstWord' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.firstWordIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'firstWord' is required. Either set @Required to field 'firstWord' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.idIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' is required. Either set @Required to field 'id' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cityName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cityName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cityName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'cityName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cityNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cityName' is required. Either set @Required to field 'cityName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("province")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'province' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("province") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'province' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.provinceIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'province' is required. Either set @Required to field 'province' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("click")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'click' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("click") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'click' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.clickIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'click' does support null values in the existing Realm file. Use corresponding boxed type for field 'click' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CityEntity' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CityEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.bm.container.module.base.Entity.CityEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.bm.container.module.base.Entity.CityEntity obj = realm.createObjectInternal(com.bm.container.module.base.Entity.CityEntity.class, true, excludeFields);
        if (json.has("firstWord")) {
            if (json.isNull("firstWord")) {
                ((CityEntityRealmProxyInterface) obj).realmSet$firstWord(null);
            } else {
                ((CityEntityRealmProxyInterface) obj).realmSet$firstWord((String) json.getString("firstWord"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((CityEntityRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((CityEntityRealmProxyInterface) obj).realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("cityName")) {
            if (json.isNull("cityName")) {
                ((CityEntityRealmProxyInterface) obj).realmSet$cityName(null);
            } else {
                ((CityEntityRealmProxyInterface) obj).realmSet$cityName((String) json.getString("cityName"));
            }
        }
        if (json.has("province")) {
            if (json.isNull("province")) {
                ((CityEntityRealmProxyInterface) obj).realmSet$province(null);
            } else {
                ((CityEntityRealmProxyInterface) obj).realmSet$province((String) json.getString("province"));
            }
        }
        if (json.has("click")) {
            if (json.isNull("click")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'click' to null.");
            } else {
                ((CityEntityRealmProxyInterface) obj).realmSet$click((boolean) json.getBoolean("click"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.bm.container.module.base.Entity.CityEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.bm.container.module.base.Entity.CityEntity obj = new com.bm.container.module.base.Entity.CityEntity();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("firstWord")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CityEntityRealmProxyInterface) obj).realmSet$firstWord(null);
                } else {
                    ((CityEntityRealmProxyInterface) obj).realmSet$firstWord((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CityEntityRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((CityEntityRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
            } else if (name.equals("cityName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CityEntityRealmProxyInterface) obj).realmSet$cityName(null);
                } else {
                    ((CityEntityRealmProxyInterface) obj).realmSet$cityName((String) reader.nextString());
                }
            } else if (name.equals("province")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CityEntityRealmProxyInterface) obj).realmSet$province(null);
                } else {
                    ((CityEntityRealmProxyInterface) obj).realmSet$province((String) reader.nextString());
                }
            } else if (name.equals("click")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'click' to null.");
                } else {
                    ((CityEntityRealmProxyInterface) obj).realmSet$click((boolean) reader.nextBoolean());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.bm.container.module.base.Entity.CityEntity copyOrUpdate(Realm realm, com.bm.container.module.base.Entity.CityEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.bm.container.module.base.Entity.CityEntity) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.bm.container.module.base.Entity.CityEntity copy(Realm realm, com.bm.container.module.base.Entity.CityEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.bm.container.module.base.Entity.CityEntity) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.bm.container.module.base.Entity.CityEntity realmObject = realm.createObjectInternal(com.bm.container.module.base.Entity.CityEntity.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CityEntityRealmProxyInterface) realmObject).realmSet$firstWord(((CityEntityRealmProxyInterface) newObject).realmGet$firstWord());
            ((CityEntityRealmProxyInterface) realmObject).realmSet$id(((CityEntityRealmProxyInterface) newObject).realmGet$id());
            ((CityEntityRealmProxyInterface) realmObject).realmSet$cityName(((CityEntityRealmProxyInterface) newObject).realmGet$cityName());
            ((CityEntityRealmProxyInterface) realmObject).realmSet$province(((CityEntityRealmProxyInterface) newObject).realmGet$province());
            ((CityEntityRealmProxyInterface) realmObject).realmSet$click(((CityEntityRealmProxyInterface) newObject).realmGet$click());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.bm.container.module.base.Entity.CityEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bm.container.module.base.Entity.CityEntity.class);
        long tableNativePtr = table.getNativeTablePointer();
        CityEntityColumnInfo columnInfo = (CityEntityColumnInfo) realm.schema.getColumnInfo(com.bm.container.module.base.Entity.CityEntity.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$firstWord = ((CityEntityRealmProxyInterface)object).realmGet$firstWord();
        if (realmGet$firstWord != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstWordIndex, rowIndex, realmGet$firstWord, false);
        }
        String realmGet$id = ((CityEntityRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$cityName = ((CityEntityRealmProxyInterface)object).realmGet$cityName();
        if (realmGet$cityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityNameIndex, rowIndex, realmGet$cityName, false);
        }
        String realmGet$province = ((CityEntityRealmProxyInterface)object).realmGet$province();
        if (realmGet$province != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.clickIndex, rowIndex, ((CityEntityRealmProxyInterface)object).realmGet$click(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bm.container.module.base.Entity.CityEntity.class);
        long tableNativePtr = table.getNativeTablePointer();
        CityEntityColumnInfo columnInfo = (CityEntityColumnInfo) realm.schema.getColumnInfo(com.bm.container.module.base.Entity.CityEntity.class);
        com.bm.container.module.base.Entity.CityEntity object = null;
        while (objects.hasNext()) {
            object = (com.bm.container.module.base.Entity.CityEntity) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$firstWord = ((CityEntityRealmProxyInterface)object).realmGet$firstWord();
                if (realmGet$firstWord != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.firstWordIndex, rowIndex, realmGet$firstWord, false);
                }
                String realmGet$id = ((CityEntityRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                }
                String realmGet$cityName = ((CityEntityRealmProxyInterface)object).realmGet$cityName();
                if (realmGet$cityName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cityNameIndex, rowIndex, realmGet$cityName, false);
                }
                String realmGet$province = ((CityEntityRealmProxyInterface)object).realmGet$province();
                if (realmGet$province != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.clickIndex, rowIndex, ((CityEntityRealmProxyInterface)object).realmGet$click(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.bm.container.module.base.Entity.CityEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bm.container.module.base.Entity.CityEntity.class);
        long tableNativePtr = table.getNativeTablePointer();
        CityEntityColumnInfo columnInfo = (CityEntityColumnInfo) realm.schema.getColumnInfo(com.bm.container.module.base.Entity.CityEntity.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$firstWord = ((CityEntityRealmProxyInterface)object).realmGet$firstWord();
        if (realmGet$firstWord != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstWordIndex, rowIndex, realmGet$firstWord, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstWordIndex, rowIndex, false);
        }
        String realmGet$id = ((CityEntityRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$cityName = ((CityEntityRealmProxyInterface)object).realmGet$cityName();
        if (realmGet$cityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityNameIndex, rowIndex, realmGet$cityName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cityNameIndex, rowIndex, false);
        }
        String realmGet$province = ((CityEntityRealmProxyInterface)object).realmGet$province();
        if (realmGet$province != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.provinceIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.clickIndex, rowIndex, ((CityEntityRealmProxyInterface)object).realmGet$click(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bm.container.module.base.Entity.CityEntity.class);
        long tableNativePtr = table.getNativeTablePointer();
        CityEntityColumnInfo columnInfo = (CityEntityColumnInfo) realm.schema.getColumnInfo(com.bm.container.module.base.Entity.CityEntity.class);
        com.bm.container.module.base.Entity.CityEntity object = null;
        while (objects.hasNext()) {
            object = (com.bm.container.module.base.Entity.CityEntity) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$firstWord = ((CityEntityRealmProxyInterface)object).realmGet$firstWord();
                if (realmGet$firstWord != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.firstWordIndex, rowIndex, realmGet$firstWord, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.firstWordIndex, rowIndex, false);
                }
                String realmGet$id = ((CityEntityRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                String realmGet$cityName = ((CityEntityRealmProxyInterface)object).realmGet$cityName();
                if (realmGet$cityName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.cityNameIndex, rowIndex, realmGet$cityName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cityNameIndex, rowIndex, false);
                }
                String realmGet$province = ((CityEntityRealmProxyInterface)object).realmGet$province();
                if (realmGet$province != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.provinceIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.clickIndex, rowIndex, ((CityEntityRealmProxyInterface)object).realmGet$click(), false);
            }
        }
    }

    public static com.bm.container.module.base.Entity.CityEntity createDetachedCopy(com.bm.container.module.base.Entity.CityEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.bm.container.module.base.Entity.CityEntity unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.bm.container.module.base.Entity.CityEntity)cachedObject.object;
            } else {
                unmanagedObject = (com.bm.container.module.base.Entity.CityEntity)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.bm.container.module.base.Entity.CityEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((CityEntityRealmProxyInterface) unmanagedObject).realmSet$firstWord(((CityEntityRealmProxyInterface) realmObject).realmGet$firstWord());
        ((CityEntityRealmProxyInterface) unmanagedObject).realmSet$id(((CityEntityRealmProxyInterface) realmObject).realmGet$id());
        ((CityEntityRealmProxyInterface) unmanagedObject).realmSet$cityName(((CityEntityRealmProxyInterface) realmObject).realmGet$cityName());
        ((CityEntityRealmProxyInterface) unmanagedObject).realmSet$province(((CityEntityRealmProxyInterface) realmObject).realmGet$province());
        ((CityEntityRealmProxyInterface) unmanagedObject).realmSet$click(((CityEntityRealmProxyInterface) realmObject).realmGet$click());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CityEntity = [");
        stringBuilder.append("{firstWord:");
        stringBuilder.append(realmGet$firstWord() != null ? realmGet$firstWord() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cityName:");
        stringBuilder.append(realmGet$cityName() != null ? realmGet$cityName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{province:");
        stringBuilder.append(realmGet$province() != null ? realmGet$province() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{click:");
        stringBuilder.append(realmGet$click());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntityRealmProxy aCityEntity = (CityEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCityEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCityEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCityEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
