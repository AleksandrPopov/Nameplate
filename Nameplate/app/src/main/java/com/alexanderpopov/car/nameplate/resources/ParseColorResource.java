package com.alexanderpopov.car.nameplate.resources;

public class ParseColorResource {

    private String mColor;
    private String mColorName;
    private String mColorCode;

    public ParseColorResource(String mColor, String mColorName, String mColorCode) {
        this.mColor = mColor;
        this.mColorName = mColorName;
        this.mColorCode = mColorCode;
    }

    public String getColor() {
        return mColor;
    }

    public String getColorName() {
        return mColorName;
    }

    public String getColorCode() {
        return mColorCode;
    }
}
