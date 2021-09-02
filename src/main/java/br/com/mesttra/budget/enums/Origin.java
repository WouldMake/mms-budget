package br.com.mesttra.budget.enums;

public enum Origin {

    FEDERAL("FEDERAL"), STATE("STATE"), COUNTY("COUNTY");

    private String value;

    private Origin(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
