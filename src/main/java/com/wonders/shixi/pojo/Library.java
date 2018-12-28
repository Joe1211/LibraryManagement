package com.wonders.shixi.pojo;

import java.util.Date;

public class Library {
    private Integer libraryId;

    private String libraryName;

    private Date libraryUpdate;

    private String libraryLocation;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName == null ? null : libraryName.trim();
    }

    public Date getLibraryUpdate() {
        return libraryUpdate;
    }

    public void setLibraryUpdate(Date libraryUpdate) {
        this.libraryUpdate = libraryUpdate;
    }

    public String getLibraryLocation() {
        return libraryLocation;
    }

    public void setLibraryLocation(String libraryLocation) {
        this.libraryLocation = libraryLocation == null ? null : libraryLocation.trim();
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryId=" + libraryId +
                ", libraryName='" + libraryName + '\'' +
                ", libraryUpdate=" + libraryUpdate +
                ", libraryLocation='" + libraryLocation + '\'' +
                '}';
    }
}