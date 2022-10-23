
package com.digio.testdigio.model.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DocumentRequest {

    @SerializedName("signers")
    @Expose
    private List<Signer> signers = null;
    @SerializedName("expire_in_days")
    @Expose
    private Integer expireInDays;
    @SerializedName("display_on_page")
    @Expose
    private String displayOnPage;
    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("file_data")
    @Expose
    private String fileData;

    public List<Signer> getSigners() {
        return signers;
    }

    public void setSigners(List<Signer> signers) {
        this.signers = signers;
    }

    public Integer getExpireInDays() {
        return expireInDays;
    }

    public void setExpireInDays(Integer expireInDays) {
        this.expireInDays = expireInDays;
    }

    public String getDisplayOnPage() {
        return displayOnPage;
    }

    public void setDisplayOnPage(String displayOnPage) {
        this.displayOnPage = displayOnPage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

}
