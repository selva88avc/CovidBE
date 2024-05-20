package com.stackroute.covid.modal;

public class TotalMap {
    public Total getTotal() {
        return total;
    }

    public TotalMap(Total total) {
        this.total = total;
    }
    public TotalMap() {

    }
    @Override
    public String toString() {
        return "TotalMap{" +
                "total=" + total +
                '}';
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    private Total total;
}
