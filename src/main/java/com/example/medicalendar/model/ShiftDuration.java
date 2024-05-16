package com.example.medicalendar.model;

public enum ShiftDuration {
    SEVEN_TO_EIGHT("7:00 - 8:00"),
    EIGHT_TO_NINE("8:00 - 9:00"),
    NINE_TO_TEN("9:00 - 10:00"),
    TEN_TO_ELEVEN("10:00 - 11:00"),
    ELEVEN_TO_TWELVE("11:00 - 12:00"),
    TWELVE_TO_THIRTEEN("12:00 - 13:00"),
    THIRTEEN_TO_FOURTEEN("13:00 - 14:00"),
    FOURTEEN_TO_FIFTEEN("14:00 - 15:00"),
    FIFTEEN_TO_SIXTEEN("15:00 - 16:00"),
    SIXTEEN_TO_SEVENTEEN("16:00 - 17:00"),
    SEVENTEEN_TO_EIGHTEEN("17:00 - 18:00"),
    EIGHTEEN_TO_NINETEEN("18:00 - 19:00"),
    NINETEEN_TO_TWENTY("19:00 - 20:00"),
    TWENTY_TO_TWENTYONE("20:00 - 21:00"),
    TWENTYONE_TO_TWENTYTWO("21:00 - 22:00"),
    TWENTYTWO_TO_TWENTYTHREE("22:00 - 23:00"),
    TWENTYTHREE_TO_TWENTYFOUR("23:00 - 24:00");

    private final String label;

    ShiftDuration(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
