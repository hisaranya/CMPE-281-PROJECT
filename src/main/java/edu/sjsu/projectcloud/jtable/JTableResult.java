package edu.sjsu.projectcloud.jtable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class JTableResult<T> {

    @JsonProperty("Result")
    private String result = "";

    @JsonProperty("Records")
    private List<T> records = new ArrayList<>();

    @JsonProperty("TotalRecordCount")
    public int getTotalRecordCount() {
        return records.size();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<T> getRecords() {
        return records;
    }

    public void addRecord(T rec) {
        records.add(rec);
    }

}
