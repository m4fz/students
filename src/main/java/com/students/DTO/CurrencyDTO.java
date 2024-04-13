package com.students.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class CurrencyDTO {
    @JsonProperty(value = "Date")
    private String date;
    @JsonProperty(value = "PreviousDate")
    private String previousDate;
    @JsonProperty(value = "PreviousURL")
    private String previousURL;
    @JsonProperty(value = "Timestamp")
    private String timestamp;

    @JsonProperty(value = "Valute")
    private Map<String, CurrencyValue> valuesMap;
    @Data
    public static class CurrencyValue {
        @JsonProperty(value = "ID")
        private String id;
        @JsonProperty(value = "NumCode")
        private String numCode;
        @JsonProperty(value = "CharCode")
        private String charCode;
        @JsonProperty(value = "Nominal")
        private String nominal;
        @JsonProperty(value = "Name")
        private String name;
        @JsonProperty(value = "Value")
        private String value;
        @JsonProperty(value = "Previous")
        private String previous;

    }
}
