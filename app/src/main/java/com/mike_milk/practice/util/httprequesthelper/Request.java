package com.mike_milk.practice.util.httprequesthelper;

public class Request  {
    private String URL;
    private String[]key;
    private String[]value;
    private String Method;
    private int Readtime;
    private int Connecttime;
    private Callback callback;
    private String contentType;

    public int getConnecttime() {
        return Connecttime;
    }

    public int getReadtime() {
        return Readtime;
    }
    public Callback getCallback() {
        return callback;
    }

    public String getContentType() {
        return contentType;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public String getURL() {
        return URL;
    }

    public String[] getKey() {
        return key;
    }

    public String[] getValue() {
        return value;
    }

    public String getMethod() {
        return Method;
    }

    Request(Builder builder){
        this.URL=builder.URL;
        this.key=builder.key;
        this.value=builder.value;
        this.Method=builder.Method;
        this.Connecttime=builder.Connecttime;
        this.Readtime=builder.Readtime;
        this.contentType = builder.contentType;
    }
    public static class Builder{
         String URL;
         String[]key=null;
         String[]value=null;
         String Method="POST";
         int Connecttime=50000;
         int Readtime=50000;
         String contentType = "application/x-www-form-urlencoded";
        public Builder(String URL){
            this.URL=URL;
        }
        public Builder key(String[]key){
            this.key=key;
           return this;
        }
        public Builder value(String[]value){
            this.value=value;
            return this;
        }
        public Builder Method(String Method){
            this.Method=Method;
            return this;
        }
        public Builder Connecttime(int Connecttime){
            this.Connecttime=Connecttime;
            return this;
        }
        public Builder Readtime(int Readtime){
            this.Readtime=Readtime;
            return this;
        }
        public Builder setContentType(String contentType){
            this.contentType = contentType;
            return this;
        }
        public Request builder(){
            return new Request(this);
        }

    }
}
