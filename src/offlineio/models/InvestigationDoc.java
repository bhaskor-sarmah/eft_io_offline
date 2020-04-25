package  offlineio.models;

public class InvestigationDoc {

    public String doc_type_code;
    public String doc_details;
    public String other_document;
    public String doc_path;


    public InvestigationDoc(String doc_type_code, String doc_details, String other_document, String doc_path) {
        this.doc_type_code = doc_type_code;
        this.doc_details = doc_details;
        this.other_document = other_document;
        this.doc_path = doc_path;
    }

    public String getDoc_type_code() {
        return doc_type_code;
    }

    public void setDoc_type_code(String doc_type_code) {
        this.doc_type_code = doc_type_code;
    }

    public String getDoc_details() {
        return doc_details;
    }

    public void setDoc_details(String doc_details) {
        this.doc_details = doc_details;
    }

    public String getOther_document() {
        return other_document;
    }

    public void setOther_document(String other_document) {
        this.other_document = other_document;
    }

    public String getDoc_path() {
        return doc_path;
    }

    public void setDoc_path(String doc_path) {
        this.doc_path = doc_path;
    }
}