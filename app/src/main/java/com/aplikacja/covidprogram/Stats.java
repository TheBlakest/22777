package com.aplikacja.covidprogram;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Stats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Stats extends Fragment {
    String url = "http://lifehacker.com/";
    ProgressDialog progressDialog;
    public TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;
    public TextView gf;
    public Button startB;
   public ArrayList<String> wojki = new ArrayList<>();
    public StringBuffer sb = new StringBuffer();
    public String test;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Stats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Stats.
     */
    // TODO: Rename and change types and number of parameters
    public static Stats newInstance(String param1, String param2) {
        Stats fragment = new Stats();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stats, container, false);
        //region zmienne
        t1 = (TextView) v.findViewById(R.id.q1);
        t2 = (TextView) v.findViewById(R.id.q2);
        t3 = (TextView) v.findViewById(R.id.q3);
        t4 = (TextView) v.findViewById(R.id.q4);
        t5 = (TextView) v.findViewById(R.id.q5);
        t6 = (TextView) v.findViewById(R.id.q6);
        t7 = (TextView) v.findViewById(R.id.q7);
        t8 = (TextView) v.findViewById(R.id.q8);
        t9 = (TextView) v.findViewById(R.id.q9);
        t10 = (TextView) v.findViewById(R.id.q10);
        t11 = (TextView) v.findViewById(R.id.q11);
        t12 = (TextView) v.findViewById(R.id.q12);
        t13 = (TextView) v.findViewById(R.id.q13);
        t14 = (TextView) v.findViewById(R.id.q14);
        t15 = (TextView) v.findViewById(R.id.q15);
        t16 = (TextView) v.findViewById(R.id.q16);
        startB = (Button) v.findViewById(R.id.buttonq);
        gf = (TextView) v.findViewById(R.id.textView8);
        //endregion
        startB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    int i =0;
                    Document doc = Jsoup.connect("https://koronawirusunas.pl/")
                            .timeout(6000).get();
                    Document doc2 = Jsoup.connect("https://www.medicover.pl/koronawirus/mapa/")
                            .timeout(6000).get();
                  /*  Elements body = doc.select("table.table.table-sm.table-borderless tbody");
                    Elements body2 = doc2.select("tbody");
                    Elements trs = doc.select("tr");
                    for (Element e : body.select("tr")) {
                        String woje = e.select("td a").text().trim();
                        String numberZ = e.select("td div.progress-bar.bg-danger").text().trim();
                        for (Element o : body2.select("tr")) {
                            boolean jest = false;
                            for (Element x : o.select("td")) {
                                String data3 = x.select("td").text();
                                if (woje.equals(data3)) {
                                    jest = true;
                                }
                            }
                            if (jest) {
                                for (Element x : o.select("td")) {
                                    String data3 = x.select("td").text();
                                    test += data3;
                                    t3.setText(test);
                                }
                            }hh

                        test += numberZ;
                    }
            */
                }catch(Exception ex){t2.setText("ehh");}
               t1.setText(test);
            }
        });
        return v;
    }

}