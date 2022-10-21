package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class selectService_for_ServiceProvider extends AppCompatActivity {
    CardView provider_painterCardView,provider_driverCardView,provider_houseKeepingCardView, provider_plumberCardView,provider_electricianCardView,provider_Ac_CardView;
    AppCompatButton btn_signIn_driver, btn_signIn_plumber;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service_for_service_provider);
        provider_houseKeepingCardView = findViewById(R.id.provider_houseKeepingCardView);
        provider_driverCardView = findViewById(R.id.provider_driverCardView);
        provider_electricianCardView = findViewById(R.id.provider_electricianCardView);
        provider_Ac_CardView = findViewById(R.id.provider_Ac_CardView);
        provider_plumberCardView = findViewById(R.id.provider_plumberCardView);
        provider_painterCardView = findViewById(R.id.provider_painterCardView);

        provider_driverCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(selectService_for_ServiceProvider.this);
                dialog.setContentView(R.layout.dialog_for_select_service_food);
                AppCompatButton btn_signUp_driver = dialog.findViewById(R.id.btn_signUp_driver);
                ImageView close = dialog.findViewById(R.id.close);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationReport;
                dialog.getWindow().setBackgroundDrawableResource(R.color.black);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
                btn_signUp_driver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(selectService_for_ServiceProvider.this, service_provider_home.class);
                        startActivity(intent);

                    }

                });
                dialog.show();
            }

        });
        provider_plumberCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(selectService_for_ServiceProvider.this);
                dialog.setContentView(R.layout.dialog_select_service_plumber);
                AppCompatButton btn_signUp_plumber = dialog.findViewById(R.id.btn_signUp_plumber);
                ImageView close_plumber = dialog.findViewById(R.id.close_plumber);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationReport;
                dialog.getWindow().setBackgroundDrawableResource(R.color.black);

                close_plumber.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
                btn_signUp_plumber.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(selectService_for_ServiceProvider.this, service_provider_home.class);
                        startActivity(intent);
                    }

                });
                dialog.show();
            }

        });
        provider_electricianCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(selectService_for_ServiceProvider.this);
                dialog.setContentView(R.layout.dialog_select_service_electrician);
                AppCompatButton btn_signUp_electrician = dialog.findViewById(R.id.btn_signUp_electrician);
                ImageView close_electrician = dialog.findViewById(R.id.close_electrician);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationReport;
                dialog.getWindow().setBackgroundDrawableResource(R.color.black);

                close_electrician.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
                btn_signUp_electrician.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(selectService_for_ServiceProvider.this, service_provider_home.class);
                        startActivity(intent);
                    }

                });
                dialog.show();
            }

        });
        provider_Ac_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(selectService_for_ServiceProvider.this);
                dialog.setContentView(R.layout.dialog_select_service_hvcr);
                AppCompatButton btn_signUp_hvcr = dialog.findViewById(R.id.btn_signUp_hvcr);
                ImageView close_hvcr = dialog.findViewById(R.id.close_hvcr);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationReport;
                dialog.getWindow().setBackgroundDrawableResource(R.color.black);

                close_hvcr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
                btn_signUp_hvcr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(selectService_for_ServiceProvider.this, service_provider_home.class);
                        startActivity(intent);
                    }

                });
                dialog.show();
            }

        });
        provider_painterCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(selectService_for_ServiceProvider.this);
                dialog.setContentView(R.layout.dialog_select_service_painter);
                AppCompatButton btn_signUp_painter = dialog.findViewById(R.id.btn_signUp_painter);
                ImageView close_painter = dialog.findViewById(R.id.close_painter);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationReport;
                dialog.getWindow().setBackgroundDrawableResource(R.color.black);

                close_painter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
                btn_signUp_painter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(selectService_for_ServiceProvider.this, service_provider_home.class);
                        startActivity(intent);
                    }

                });
                dialog.show();
            }

        });
        provider_houseKeepingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(selectService_for_ServiceProvider.this);
                dialog.setContentView(R.layout.dialog_select_service_house_keeping);
                AppCompatButton btn_signUp_houseKeeping = dialog.findViewById(R.id.btn_signUp_houseKeeping);
                ImageView close_houseKeeping = dialog.findViewById(R.id.close_houseKeeping);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationReport;
                dialog.getWindow().setBackgroundDrawableResource(R.color.black);

                close_houseKeeping.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
                btn_signUp_houseKeeping.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(selectService_for_ServiceProvider.this, service_provider_home.class);
                        startActivity(intent);
                    }

                });
                dialog.show();
            }

        });
    }
}


