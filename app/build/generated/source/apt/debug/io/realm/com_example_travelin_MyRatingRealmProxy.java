package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_travelin_MyRatingRealmProxy extends com.example.travelin.MyRating
    implements RealmObjectProxy, com_example_travelin_MyRatingRealmProxyInterface {

    static final class MyRatingColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long typeIndex;
        long authorIndex;
        long datePostedIndex;
        long bodyIndex;
        long ratingIndex;

        MyRatingColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MyRating");
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.authorIndex = addColumnDetails("author", "author", objectSchemaInfo);
            this.datePostedIndex = addColumnDetails("datePosted", "datePosted", objectSchemaInfo);
            this.bodyIndex = addColumnDetails("body", "body", objectSchemaInfo);
            this.ratingIndex = addColumnDetails("rating", "rating", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        MyRatingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MyRatingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MyRatingColumnInfo src = (MyRatingColumnInfo) rawSrc;
            final MyRatingColumnInfo dst = (MyRatingColumnInfo) rawDst;
            dst.typeIndex = src.typeIndex;
            dst.authorIndex = src.authorIndex;
            dst.datePostedIndex = src.datePostedIndex;
            dst.bodyIndex = src.bodyIndex;
            dst.ratingIndex = src.ratingIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MyRatingColumnInfo columnInfo;
    private ProxyState<com.example.travelin.MyRating> proxyState;

    com_example_travelin_MyRatingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MyRatingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.travelin.MyRating>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    @Override
    public com.example.travelin.User realmGet$author() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.authorIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.travelin.User.class, proxyState.getRow$realm().getLink(columnInfo.authorIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$author(com.example.travelin.User value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("author")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.authorIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.authorIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.authorIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.authorIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$datePosted() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.datePostedIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.datePostedIndex);
    }

    @Override
    public void realmSet$datePosted(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.datePostedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.datePostedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.datePostedIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.datePostedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$body() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.bodyIndex);
    }

    @Override
    public void realmSet$body(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bodyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.bodyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bodyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.bodyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$rating() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.ratingIndex);
    }

    @Override
    public void realmSet$rating(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.ratingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.ratingIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("MyRating", 5, 0);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("author", RealmFieldType.OBJECT, "User");
        builder.addPersistedProperty("datePosted", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("body", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("rating", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MyRatingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MyRatingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MyRating";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MyRating";
    }

    @SuppressWarnings("cast")
    public static com.example.travelin.MyRating createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("author")) {
            excludeFields.add("author");
        }
        com.example.travelin.MyRating obj = realm.createObjectInternal(com.example.travelin.MyRating.class, true, excludeFields);

        final com_example_travelin_MyRatingRealmProxyInterface objProxy = (com_example_travelin_MyRatingRealmProxyInterface) obj;
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("author")) {
            if (json.isNull("author")) {
                objProxy.realmSet$author(null);
            } else {
                com.example.travelin.User authorObj = com_example_travelin_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("author"), update);
                objProxy.realmSet$author(authorObj);
            }
        }
        if (json.has("datePosted")) {
            if (json.isNull("datePosted")) {
                objProxy.realmSet$datePosted(null);
            } else {
                Object timestamp = json.get("datePosted");
                if (timestamp instanceof String) {
                    objProxy.realmSet$datePosted(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$datePosted(new Date(json.getLong("datePosted")));
                }
            }
        }
        if (json.has("body")) {
            if (json.isNull("body")) {
                objProxy.realmSet$body(null);
            } else {
                objProxy.realmSet$body((String) json.getString("body"));
            }
        }
        if (json.has("rating")) {
            if (json.isNull("rating")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rating' to null.");
            } else {
                objProxy.realmSet$rating((double) json.getDouble("rating"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.travelin.MyRating createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.travelin.MyRating obj = new com.example.travelin.MyRating();
        final com_example_travelin_MyRatingRealmProxyInterface objProxy = (com_example_travelin_MyRatingRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else if (name.equals("author")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$author(null);
                } else {
                    com.example.travelin.User authorObj = com_example_travelin_UserRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$author(authorObj);
                }
            } else if (name.equals("datePosted")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$datePosted(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$datePosted(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$datePosted(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("body")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$body((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$body(null);
                }
            } else if (name.equals("rating")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rating((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rating' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_example_travelin_MyRatingRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating uexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.travelin.MyRating.class), false, Collections.<String>emptyList());
        io.realm.com_example_travelin_MyRatingRealmProxy obj = new io.realm.com_example_travelin_MyRatingRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.travelin.MyRating copyOrUpdate(Realm realm, MyRatingColumnInfo columnInfo, com.example.travelin.MyRating object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.travelin.MyRating) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.travelin.MyRating copy(Realm realm, MyRatingColumnInfo columnInfo, com.example.travelin.MyRating newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.travelin.MyRating) cachedRealmObject;
        }

        com_example_travelin_MyRatingRealmProxyInterface realmObjectSource = (com_example_travelin_MyRatingRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.travelin.MyRating.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.typeIndex, realmObjectSource.realmGet$type());
        builder.addDate(columnInfo.datePostedIndex, realmObjectSource.realmGet$datePosted());
        builder.addString(columnInfo.bodyIndex, realmObjectSource.realmGet$body());
        builder.addDouble(columnInfo.ratingIndex, realmObjectSource.realmGet$rating());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_travelin_MyRatingRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.example.travelin.User authorObj = realmObjectSource.realmGet$author();
        if (authorObj == null) {
            realmObjectCopy.realmSet$author(null);
        } else {
            com.example.travelin.User cacheauthor = (com.example.travelin.User) cache.get(authorObj);
            if (cacheauthor != null) {
                realmObjectCopy.realmSet$author(cacheauthor);
            } else {
                realmObjectCopy.realmSet$author(com_example_travelin_UserRealmProxy.copyOrUpdate(realm, (com_example_travelin_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(com.example.travelin.User.class), authorObj, update, cache, flags));
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.example.travelin.MyRating object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.travelin.MyRating.class);
        long tableNativePtr = table.getNativePtr();
        MyRatingColumnInfo columnInfo = (MyRatingColumnInfo) realm.getSchema().getColumnInfo(com.example.travelin.MyRating.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$type = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }

        com.example.travelin.User authorObj = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$author();
        if (authorObj != null) {
            Long cacheauthor = cache.get(authorObj);
            if (cacheauthor == null) {
                cacheauthor = com_example_travelin_UserRealmProxy.insert(realm, authorObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.authorIndex, rowIndex, cacheauthor, false);
        }
        java.util.Date realmGet$datePosted = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$datePosted();
        if (realmGet$datePosted != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.datePostedIndex, rowIndex, realmGet$datePosted.getTime(), false);
        }
        String realmGet$body = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$body();
        if (realmGet$body != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bodyIndex, rowIndex, realmGet$body, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.ratingIndex, rowIndex, ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$rating(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.travelin.MyRating.class);
        long tableNativePtr = table.getNativePtr();
        MyRatingColumnInfo columnInfo = (MyRatingColumnInfo) realm.getSchema().getColumnInfo(com.example.travelin.MyRating.class);
        com.example.travelin.MyRating object = null;
        while (objects.hasNext()) {
            object = (com.example.travelin.MyRating) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$type = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }

            com.example.travelin.User authorObj = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$author();
            if (authorObj != null) {
                Long cacheauthor = cache.get(authorObj);
                if (cacheauthor == null) {
                    cacheauthor = com_example_travelin_UserRealmProxy.insert(realm, authorObj, cache);
                }
                table.setLink(columnInfo.authorIndex, rowIndex, cacheauthor, false);
            }
            java.util.Date realmGet$datePosted = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$datePosted();
            if (realmGet$datePosted != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.datePostedIndex, rowIndex, realmGet$datePosted.getTime(), false);
            }
            String realmGet$body = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$body();
            if (realmGet$body != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bodyIndex, rowIndex, realmGet$body, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.ratingIndex, rowIndex, ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$rating(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.travelin.MyRating object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.travelin.MyRating.class);
        long tableNativePtr = table.getNativePtr();
        MyRatingColumnInfo columnInfo = (MyRatingColumnInfo) realm.getSchema().getColumnInfo(com.example.travelin.MyRating.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$type = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }

        com.example.travelin.User authorObj = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$author();
        if (authorObj != null) {
            Long cacheauthor = cache.get(authorObj);
            if (cacheauthor == null) {
                cacheauthor = com_example_travelin_UserRealmProxy.insertOrUpdate(realm, authorObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.authorIndex, rowIndex, cacheauthor, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.authorIndex, rowIndex);
        }
        java.util.Date realmGet$datePosted = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$datePosted();
        if (realmGet$datePosted != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.datePostedIndex, rowIndex, realmGet$datePosted.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.datePostedIndex, rowIndex, false);
        }
        String realmGet$body = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$body();
        if (realmGet$body != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bodyIndex, rowIndex, realmGet$body, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bodyIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.ratingIndex, rowIndex, ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$rating(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.travelin.MyRating.class);
        long tableNativePtr = table.getNativePtr();
        MyRatingColumnInfo columnInfo = (MyRatingColumnInfo) realm.getSchema().getColumnInfo(com.example.travelin.MyRating.class);
        com.example.travelin.MyRating object = null;
        while (objects.hasNext()) {
            object = (com.example.travelin.MyRating) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$type = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }

            com.example.travelin.User authorObj = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$author();
            if (authorObj != null) {
                Long cacheauthor = cache.get(authorObj);
                if (cacheauthor == null) {
                    cacheauthor = com_example_travelin_UserRealmProxy.insertOrUpdate(realm, authorObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.authorIndex, rowIndex, cacheauthor, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.authorIndex, rowIndex);
            }
            java.util.Date realmGet$datePosted = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$datePosted();
            if (realmGet$datePosted != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.datePostedIndex, rowIndex, realmGet$datePosted.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.datePostedIndex, rowIndex, false);
            }
            String realmGet$body = ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$body();
            if (realmGet$body != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bodyIndex, rowIndex, realmGet$body, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.bodyIndex, rowIndex, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.ratingIndex, rowIndex, ((com_example_travelin_MyRatingRealmProxyInterface) object).realmGet$rating(), false);
        }
    }

    public static com.example.travelin.MyRating createDetachedCopy(com.example.travelin.MyRating realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.travelin.MyRating unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.travelin.MyRating();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.travelin.MyRating) cachedObject.object;
            }
            unmanagedObject = (com.example.travelin.MyRating) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_travelin_MyRatingRealmProxyInterface unmanagedCopy = (com_example_travelin_MyRatingRealmProxyInterface) unmanagedObject;
        com_example_travelin_MyRatingRealmProxyInterface realmSource = (com_example_travelin_MyRatingRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());

        // Deep copy of author
        unmanagedCopy.realmSet$author(com_example_travelin_UserRealmProxy.createDetachedCopy(realmSource.realmGet$author(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$datePosted(realmSource.realmGet$datePosted());
        unmanagedCopy.realmSet$body(realmSource.realmGet$body());
        unmanagedCopy.realmSet$rating(realmSource.realmGet$rating());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MyRating = proxy[");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{author:");
        stringBuilder.append(realmGet$author() != null ? "User" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{datePosted:");
        stringBuilder.append(realmGet$datePosted() != null ? realmGet$datePosted() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{body:");
        stringBuilder.append(realmGet$body() != null ? realmGet$body() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rating:");
        stringBuilder.append(realmGet$rating());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
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
        com_example_travelin_MyRatingRealmProxy aMyRating = (com_example_travelin_MyRatingRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMyRating.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMyRating.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMyRating.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
