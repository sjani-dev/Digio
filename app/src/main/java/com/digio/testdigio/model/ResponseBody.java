package com.digio.testdigio.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBody {
@SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_agreement")
    @Expose
    private Boolean isAgreement;
    @SerializedName("agreement_type")
    @Expose
    private String agreementType;
    @SerializedName("agreement_status")
    @Expose
    private String agreementStatus;
    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("self_signed")
    @Expose
    private Boolean selfSigned;
    @SerializedName("self_sign_type")
    @Expose
    private String selfSignType;
    @SerializedName("no_of_pages")
    @Expose
    private Integer noOfPages;
    @SerializedName("signing_parties")
    @Expose
    private List<SigningParty> signingParties = null;
    @SerializedName("sign_request_details")
    @Expose
    private SignRequestDetails signRequestDetails;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("other_doc_details")
    @Expose
    private OtherDocDetails otherDocDetails;
    @SerializedName("attached_estamp_details")
    @Expose
    private AttachedEstampDetails attachedEstampDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsAgreement() {
        return isAgreement;
    }

    public void setIsAgreement(Boolean isAgreement) {
        this.isAgreement = isAgreement;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getSelfSigned() {
        return selfSigned;
    }

    public void setSelfSigned(Boolean selfSigned) {
        this.selfSigned = selfSigned;
    }

    public String getSelfSignType() {
        return selfSignType;
    }

    public void setSelfSignType(String selfSignType) {
        this.selfSignType = selfSignType;
    }

    public Integer getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(Integer noOfPages) {
        this.noOfPages = noOfPages;
    }

    public List<SigningParty> getSigningParties() {
        return signingParties;
    }

    public void setSigningParties(List<SigningParty> signingParties) {
        this.signingParties = signingParties;
    }

    public SignRequestDetails getSignRequestDetails() {
        return signRequestDetails;
    }

    public void setSignRequestDetails(SignRequestDetails signRequestDetails) {
        this.signRequestDetails = signRequestDetails;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public OtherDocDetails getOtherDocDetails() {
        return otherDocDetails;
    }

    public void setOtherDocDetails(OtherDocDetails otherDocDetails) {
        this.otherDocDetails = otherDocDetails;
    }

    public AttachedEstampDetails getAttachedEstampDetails() {
        return attachedEstampDetails;
    }

    public void setAttachedEstampDetails(AttachedEstampDetails attachedEstampDetails) {
        this.attachedEstampDetails = attachedEstampDetails;
    }

}
