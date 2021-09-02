package br.com.mesttra.budget.enums;

public enum Origin {

    KEEPER("FEDERAL"), DEFENDER("STATE"), MIDFIELDER("COUNTY");

    private String value;

    private Origin(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
