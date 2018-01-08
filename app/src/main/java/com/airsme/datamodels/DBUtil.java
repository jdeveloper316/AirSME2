package com.airsme.datamodels;

/**
 * Created by user on 12/12/2017.
 */

        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.firebase.database.ChildEventListener;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class DBUtil {

    private Boolean success=null;
    private static DatabaseReference mDatabase=FirebaseDatabase.getInstance().getReference();

    public static boolean createModel(Model model) {
        String key = mDatabase.child(model.getNode()).push().getKey();

        Map<String, Object> childUpdates = new HashMap<>();
        model.setID(key);

        mDatabase.child(model.getNode()).child(model.getID()).setValue(model);

        mDatabase.updateChildren(childUpdates);
        return false;
    }

    public static boolean retriaveModel(final String node, String key, String value) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dinosaursRef = database.getReference(node);
        dinosaursRef.orderByChild(key).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Model model=null;
                switch(node) {
                    case "proxy":
                        model = dataSnapshot.getValue(Proxy.class); break;
                    case "business":
                        model = dataSnapshot.getValue(Business.class); break;
                    case "individual":
                        model = dataSnapshot.getValue(Individual.class); break;
                    case "tender":
                        model = dataSnapshot.getValue(Tender.class); break;
                    case "user":
                        model = dataSnapshot.getValue(User.class); break;
                }
                //display the items
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return true;
    }

    public static Model retriaveModelByKey(final Model m) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dinosaursRef = database.getReference(m.getNode());
        final List<Model> result=new ArrayList();

        dinosaursRef.orderByChild(m.getID()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Model model=null;
                String node=m.getNode();
                switch(node) {
                    case "proxy":
                        model = dataSnapshot.getValue(Proxy.class); break;
                    case "business":
                        model = dataSnapshot.getValue(Business.class); break;
                    case "individual":
                        model = dataSnapshot.getValue(Individual.class); break;
                    case "tender":
                        model = dataSnapshot.getValue(Tender.class); break;
                    case "user":
                        model = dataSnapshot.getValue(User.class); break;
                }
                result.add(model);
                //display the items
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return (!result.isEmpty())?result.get(0):null;
    }

    public static boolean searchModel(String key) {


        return true;
    }

    public static boolean filterModel(List<String> key, List<String> node) {

        return true;
    }

    public static boolean updateModel(Model model) {
        String key = model.getID();

        Map<String, Object> childUpdates = new HashMap<>();
        model.setID(key);

        mDatabase.child(model.getNode()).child(model.getID()).setValue(model);

        mDatabase.updateChildren(childUpdates);
        return true;
    }

    public static boolean deleteModel(Model model) {

        return true;
    }
}