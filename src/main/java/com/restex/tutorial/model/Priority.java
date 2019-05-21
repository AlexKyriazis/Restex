package com.restex.tutorial.model;

public enum Priority {
    HIGH("high"),
    LOW("low");
    private String text;

    Priority(String text) {
        this.text = text;
    }

    public static Priority fromString(String text) {
        for (Priority b : Priority.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getText() {
        return this.text;
    }
}
