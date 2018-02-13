package com.airsme.airsme2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airsme.datamodels.Proxy;
import com.airsme.datamodels.Tender;
import com.mobile.connect.checkout.dialog.PWConnectCheckoutActivity;
import com.mobile.connect.checkout.meta.PWConnectCheckoutSettings;
import com.mobile.connect.payment.PWCurrency;

import java.math.BigDecimal;
import java.util.EnumSet;

import io.mpos.accessories.AccessoryFamily;
import io.mpos.accessories.parameters.AccessoryParameters;
import io.mpos.provider.ProviderMode;
import io.mpos.transactions.Currency;
import io.mpos.transactions.Transaction;
import io.mpos.transactions.parameters.TransactionParameters;
import io.mpos.ui.shared.MposUi;
import io.mpos.ui.shared.model.MposUiConfiguration;

public class BProxyInfor extends AppCompatActivity {

    public static Proxy proxy;
    public static Tender subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bproxy_infor);

        TextView name=findViewById(R.id.pname);
        name.setEnabled(false);
        name.setText(proxy.getTitle()+" "+proxy.getName()+" "+proxy.getSurname());
        TextView edu=findViewById(R.id.peducation);
        edu.setEnabled(false);
        edu.setText(proxy.getEducation());
        TextView lang=findViewById(R.id.planguages);
        lang.setEnabled(false);
        lang.setText(proxy.getLanguages());
        TextView prof=findViewById(R.id.pprofesion);
        prof.setEnabled(false);
        prof.setText(proxy.getProfession());
        TextView about=findViewById(R.id.bproxy_infor_text);
        about.setEnabled(false);
        about.setText(proxy.getAboutme());
        Button b=findViewById(R.id.bproxy_infor_paymentbtn);

        ImageView profile = findViewById(R.id.pimage);
        profile.setPadding(0,0,0,0);
        //prof.setCropToPadding(true);
        profile.setImageResource(R.drawable.com_facebook_profile_picture_blank_portrait);
        new GlobalStorage(this).loadImage(proxy.getPic(), profile);

        b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               pay();
           }
       });

        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.bproxyinfor_main));
        getSupportActionBar().setTitle(proxy.getName());
    }
    /*private void pay2(){
        MposUi ui = MposUi.initialize(this, ProviderMode.MOCK,
                "merchantIdentifier", "merchantSecretKey");

        ui.getConfiguration().setSummaryFeatures(EnumSet.of(
                // Add this line, if you do want to offer printed receipts
                // MposUiConfiguration.SummaryFeature.PRINT_RECEIPT,
                MposUiConfiguration.SummaryFeature.SEND_RECEIPT_VIA_EMAIL)
        );

        // Start with a mocked card reader:
        AccessoryParameters accessoryParameters = new AccessoryParameters.Builder(AccessoryFamily.MOCK)
                .mocked()
                .build();
        ui.getConfiguration().setTerminalParameters(accessoryParameters);

        // Add this line if you would like to collect the customer signature on the receipt (as opposed to the digital signature)
        // ui.getConfiguration().setSignatureCapture(MposUiConfiguration.SignatureCapture.ON_RECEIPT);


    /* When using the Bluetooth Miura, use the following parameters:
    AccessoryParameters accessoryParameters = new AccessoryParameters.Builder(AccessoryFamily.MIURA_MPI)
                                                                     .bluetooth()
                                                                     .build();
    ui.getConfiguration().setTerminalParameters(accessoryParameters);
    */




    /* When using Verifone readers via WiFi or Ethernet, use the following parameters:
    AccessoryParameters accessoryParameters = new AccessoryParameters.Builder(AccessoryFamily.VERIFONE_VIPA)
                                                                     .tcp("192.168.254.123", 16107)
                                                                     .build();
    ui.getConfiguration().setTerminalParameters(accessoryParameters);
    *********** //

        TransactionParameters transactionParameters = new TransactionParameters.Builder()
                .charge(new BigDecimal(""+MapsMarkerActivity.calculateCost(proxy.jgetMaplocation(), subject.jgetMaplocation())), Currency.ZAR)
                .subject(proxy.getName())
                .customIdentifier("yourReferenceForTheTransaction")
                .build();

        Intent intent = ui.createTransactionIntent(transactionParameters);
        startActivityForResult(intent, MposUi.REQUEST_CODE_PAYMENT);
    }*/

    private void pay(){
        PWConnectCheckoutActivity.checkoutSettings= new PWConnectCheckoutSettings();
        PWConnectCheckoutActivity.checkoutSettings.setPaymentAmount(66);
        PWConnectCheckoutActivity.checkoutSettings.setPaymentCurrency(PWCurrency.SOUTH_AFRICA_RAND);
        Globals.nextView(BProxyInfor.this, ShoppingActivity.class);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MposUi.REQUEST_CODE_PAYMENT) {
            if (resultCode == MposUi.RESULT_CODE_APPROVED) {
                // Transaction was approved
                Toast.makeText(this, "Transaction approved", Toast.LENGTH_LONG).show();
            } else {
                // Card was declined, or transaction was aborted, or failed
                // (e.g. no internet or accessory not found)
                Toast.makeText(this, "Transaction was declined, aborted, or failed",
                        Toast.LENGTH_LONG).show();
            }
            // Grab the processed transaction in case you need it
            // (e.g. the transaction identifier for a refund).
            // Keep in mind that the returned transaction might be null
            // (e.g. if it could not be registered).
            Transaction transaction = MposUi.getInitializedInstance().getTransaction();
        }
    }
}
