package com.heartygas;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerRegisterFragment extends Fragment {

    TextView customerRegisterToSignInClick;
    Button customerRegisterToHomeButton;
    EditText customerfirstNameTextFieldEdit;
    EditText customerlastNameTextFieldEdit;
    EditText customerpasswordTextFieldEdit;
    EditText customeraddressTextFieldEdit;
    EditText customerphoneTextFieldEdit;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customer_register, container, false);

        customerRegisterToSignInClick = view.findViewById(R.id.customerLoginText);

        customerRegisterToSignInClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        customerfirstNameTextFieldEdit = view.findViewById(R.id.customerFirstNameTextField);
        customerlastNameTextFieldEdit = view.findViewById(R.id.customerLastNameTextField);
        customerpasswordTextFieldEdit = view.findViewById(R.id.customerPasswordTextField);
        customeraddressTextFieldEdit = view.findViewById(R.id.customerAddressTextField);
        customerphoneTextFieldEdit = view.findViewById(R.id.customerPhoneTextField);


        customerRegisterToHomeButton = view.findViewById(R.id.customerRegisterButton);

        customerRegisterToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (customerlastNameTextFieldEdit.getText().toString().isEmpty() || customerfirstNameTextFieldEdit.getText().toString().isEmpty() || customerpasswordTextFieldEdit.getText().toString().isEmpty() || customeraddressTextFieldEdit.getText().toString().isEmpty() || customerphoneTextFieldEdit.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please fill in the details", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(), CustomerHomeActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;

    }

}
