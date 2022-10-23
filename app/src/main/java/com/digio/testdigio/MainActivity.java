package com.digio.testdigio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.digio.testdigio.databinding.ActivityMainBinding;
import com.digio.testdigio.model.ResponseBody;
import com.digio.testdigio.viewmodel.MainViewModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private DisposableObserver observer;
    private String encoded;
    ActivityMainBinding binding;
    public ResponseBody responseBody;
    private ProgressDialog progressDialog;

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getresponseBodyMutableLiveData().observe(this, observeUI);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void init(){
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setMainViewModel(viewModel);
        binding.setLifecycleOwner(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        binding.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFromDevice();
            }
        });
        binding.btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadDocument(encoded);
            }
        });
    }

    public void selectFromDevice(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), 0600);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0600:
                if(resultCode == RESULT_OK){
                    if (data.getData() != null) {
                        Uri uri = data.getData();
                        try {
                            InputStream ips = getContentResolver().openInputStream(uri);
                            byte[] bytes = new byte[ips.available()];
                            ips.read(bytes, 0, bytes.length);
                            encoded = Base64.encodeToString(bytes,Base64.NO_WRAP);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(null==encoded){
                        binding.btnUpload.setEnabled(false);
                        binding.btnSelect.setEnabled(true);
                    }else{
                        binding.btnUpload.setEnabled(true);
                        binding.btnSelect.setEnabled(false);
                    }
                }
                break;
        }
    }

    private void uploadDocument(String document) {
        progressDialog.show();
        observer = new DisposableObserver<Response<ResponseBody>>() {
            @Override
            public void onNext(Response response) {
                responseBody = (ResponseBody) response.body();
                viewModel.updateData((ResponseBody) response.body());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(getApplicationContext(), "Not Uploaded", Toast.LENGTH_SHORT).show();
                viewModel.getError(e.getCause().getMessage().toString());
            }

            @Override
            public void onComplete() {
                binding.cvResponse.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                viewModel.getData();
                encoded= null;
                if(null==encoded){
                    binding.btnUpload.setEnabled(false);
                    binding.btnSelect.setEnabled(true);
                }else{
                    binding.btnUpload.setEnabled(true);
                    binding.btnSelect.setEnabled(false);
                }
                progressDialog.dismiss();
            }
        };
        try {
            viewModel.setData(observer,document);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private androidx.lifecycle.Observer<ResponseBody> observeUI = new Observer<ResponseBody>() {
        @Override
        public void onChanged(@Nullable ResponseBody responseBody) {

        }
    };

}