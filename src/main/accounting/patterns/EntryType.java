package main.accounting.patterns;

import java.util.Arrays;

public enum EntryType {

    BASE_USAGE("Base usage"),
    SERVICE("Service Fee");

    private final String name;

    EntryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EntryType fromName(String name) {
        return Arrays.stream(values())
                .filter(type -> type.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No EntryType found for name: " + name));
    }
}