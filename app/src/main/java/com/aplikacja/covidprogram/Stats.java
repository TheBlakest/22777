package com.aplikacja.covidprogram;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    public ArrayList<String> liczb = new ArrayList<>();
    public ArrayList<String> liczb10 = new ArrayList<>();
    public ArrayList<String> liczbSm = new ArrayList<>();
    public ArrayList<String> liczbZak = new ArrayList<>();
    public StringBuffer sb = new StringBuffer();
    public String test;

    String test1 = "", test2="", test3="",test4="", test5="", test11="";



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
            gf = (TextView) v.findViewById(R.id.textView8);
            //endregion
        new doinbackground().execute();


        return v;
    }

    public void setvalue(){
        t1.setText(wojki.get(15));
        t2.setText(liczb.get(15));
        t3.setText(liczb10.get(15));
        t4.setText(liczbSm.get(15));
        t5.setText(liczbZak.get(15));

    }

    class doinbackground extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            setvalue();
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document docum = Jsoup.connect("https://koronawirusunas.pl/")
                        .timeout(30*1000)
                        .get();
                Document docum2 = Jsoup.connect("https://www.medicover.pl/koronawirus/mapa/")
                        .timeout(6000)
                        .get();
                Elements element = docum.select("table.table.table-sm.table-borderless tbody");
                Elements element2 = docum2.select("tbody");

                for (Element e: element.select("tr")) {
                    for (int l = 0; l < 1; l++) {
                        test11 = e.select("td a").text();
                        for (Element o : element2.select("tr")) {
                            boolean jest = false;
                            for (Element x : o.select("td")) {
                                String data3 = x.select("td").text();
                                if (test11.equals(data3)) {
                                    jest = true;
                                }}
                                if (jest) {
                                    int i = 0;
                                    for (Element r : o.select("td")) {
                                        if (i == 0) {
                                            test1 += r.select("td").text();
                                            test1 += "\n";
                                            wojki.add(test1);
                                        }
                                        if (i == 1) {
                                            test2 += r.select("td").text();
                                            test2 += "\n";
                                            liczb.add(test2);
                                        }
                                        if (i == 2) {
                                            test3 += r.select("td").text();
                                            test3 += "\n";
                                            liczb10.add(test3);
                                        }
                                        if (i == 3) {
                                            test4 += r.select("td").text();
                                            test4 += "\n";
                                            liczbSm.add(test4);
                                        }
                                        i++;
                                    }

                            }
                        }
                         test5 += e.select("td div.progress-bar.bg-danger").text();
                        test5 += "\n";
                       liczbZak.add(test5);
                    }
                }
                  /*  if(i==1){
                        zmiena = e.select("td a").text();
                        for (Element o : element2.select("tr")) {
                            boolean jest = false;
                            for (Element x : o.select("td")) {
                                String data3 = x.select("td").text();
                                if (zmiena.equals(data3)) {
                                    jest = true;
                                }
                            }
                            if (jest) {
                                for (Element x : o.select("td")) {
                                    test2 += x.select("td").text();
                                    test2 += " ";
                                }
                            }
                        }
                        test2=e.select("td div.progress-bar.bg-danger").text();
                        Log.d("abc", "doInBackground: "+test2);
                    }
                    if(i==2){
                        zmiena += e.select("td a").text();
                        for (Element o : element2.select("tr")) {
                            boolean jest = false;
                            for (Element x : o.select("td")) {
                                String data3 = x.select("td").text();
                                if (zmiena.equals(data3)) {
                                    jest = true;
                                }
                            }
                            if (jest) {
                                for (Element x : o.select("td")) {
                                    test3 += x.select("td").text();
                                    test3 += " ";
                                }
                            }
                        }
                        test3+=e.select("td div.progress-bar.bg-danger").text();
                        Log.d("abc", "doInBackground: "+test3);
                    }
                    i++;
                }
*/


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
/*
                try {
                        int i =0;
                        Document doc = Jsoup.connect("https://koronawirusunas.pl/")
                        .timeout(6000).get();
                        Document doc2 = Jsoup.connect("https://www.medicover.pl/koronawirus/mapa/")
                        .timeout(6000).get();
                        Elements body = doc.select("table.table.table-sm.table-borderless tbody");
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

                        }catch(Exception ex){t2.setText("ehh");}
                        t1.setText(test);
                        }
                        });
                        */