package com.heartygas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VendorRegisterFragment extends Fragment {

    TextView vendorRegisterToSignInClick;
    Button vendorRegisterToHomeButton;
    EditText vendorPasswordTextFieldEdit;
    EditText vendorEmailTextFieldEdit;
    EditText vendorPhoneNumberTextFieldEdit;
    EditText vendorCompanyNameTextFieldEdit;
    EditText vendorLastNameTextFieldEdit;
    EditText vendorFirstNameTextFieldEdit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.vendor_register, container, false);

        vendorRegisterToSignInClick = view.findViewById(R.id.vendorLoginText);

        vendorRegisterToSignInClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        vendorPasswordTextFieldEdit = view.findViewById(R.id.vendorPasswordTextField);
        vendorEmailTextFieldEdit = view.findViewById(R.id.vendorEmailTextField);
        vendorPhoneNumberTextFieldEdit = view.findViewById(R.id.vendorPhoneNumberTextField);
        vendorCompanyNameTextFieldEdit = view.findViewById(R.id.vendorCompanyNameTextField);
        vendorLastNameTextFieldEdit = view.findViewById(R.id.vendorLastNameTextField);
        vendorFirstNameTextFieldEdit = view.findViewById(R.id.vendorFirstNameTextField);

        vendorRegisterToHomeButton = view.findViewById(R.id.vendorRegisterButton);

        vendorRegisterToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vendorPasswordTextFieldEdit.getText().toString().isEmpty() ||
                        vendorEmailTextFieldEdit.getText().toString().isEmpty() ||
                        vendorPhoneNumberTextFieldEdit.getText().toString().isEmpty() ||
                        vendorCompanyNameTextFieldEdit.getText().toString().isEmpty() ||
                        vendorLastNameTextFieldEdit.getText().toString().isEmpty() ||
                        vendorFirstNameTextFieldEdit.getText().toString().isEmpty()
                ) {
                    Toast.makeText(getContext(), "Please fill in the details", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(), HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}
