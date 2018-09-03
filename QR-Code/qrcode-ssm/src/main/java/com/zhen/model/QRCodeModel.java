package com.zhen.model;

/**
 * Created by zhenyonghe on 2017/5/3.
 */
public class QRCodeModel {

    private String outType;
    private String text;
    private String errorCorrectLevel;
    private String qrCodeLevel;
    private String offset;
    private String size;

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getErrorCorrectLevel() {
        return errorCorrectLevel;
    }

    public void setErrorCorrectLevel(String errorCorrectLevel) {
        this.errorCorrectLevel = errorCorrectLevel;
    }

    public String getQrCodeLevel() {
        return qrCodeLevel;
    }

    public void setQrCodeLevel(String qrCodeLevel) {
        this.qrCodeLevel = qrCodeLevel;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "QRCodeModel{" +
                "outType='" + outType + '\'' +
                ", text='" + text + '\'' +
                ", errorCorrectLevel='" + errorCorrectLevel + '\'' +
                ", qrCodeLevel='" + qrCodeLevel + '\'' +
                ", offset='" + offset + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
