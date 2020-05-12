package  offlineio.models;


import java.util.ArrayList;

public class FurtherInvestigation {

    String commId;
    String onlineId;
    String suspectName;
    String fatherName;
    String motherName;
    String mobileNumber;
    String requestRemark;
    ArrayList<String> commentList;
    String photoPath;

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public FurtherInvestigation(String commId, String onlineId, String suspectName, String fatherName, String  motherName, String mobileNumber, String requestRemark, String photoPath,ArrayList<String> commentList) {
        this.commId = commId;
        this.onlineId = onlineId;
        this.suspectName = suspectName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.mobileNumber = mobileNumber;
        this.requestRemark = requestRemark;
        this.photoPath = photoPath;
        this.commentList = commentList;
    }

    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId;
    }

    public String getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(String onlineId) {
        this.onlineId = onlineId;
    }

    public String getSuspectName() {
        return suspectName;
    }

    public void setSuspectName(String suspectName) {
        this.suspectName = suspectName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRequestRemark() {
        return requestRemark;
    }

    public void setRequestRemark(String requestRemark) {
        this.requestRemark = requestRemark;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public ArrayList<String> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<String> commentList) {
        this.commentList = commentList;
    }
}
