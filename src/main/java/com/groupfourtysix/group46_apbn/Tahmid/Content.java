package com.groupfourtysix.group46_apbn.Tahmid;

public class Content {
    private String itemName;
    private String flagReason;
    private String itemDetails;
    private String status;

    public Content(String itemName, String flagReason, String itemDetails, String status) {
        this.itemName = itemName;
        this.flagReason = flagReason;
        this.itemDetails = itemDetails;
        this.status = status;
    }

    public Content() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getFlagReason() {
        return flagReason;
    }

    public void setFlagReason(String flagReason) {
        this.flagReason = flagReason;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Content{" +
                "itemName='" + itemName + '\'' +
                ", flagReason='" + flagReason + '\'' +
                ", itemDetails='" + itemDetails + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
