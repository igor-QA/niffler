package niffler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import niffler.api.base.BaseDto;

import java.util.Date;
import java.util.UUID;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Spend extends BaseDto {
        @Getter @Setter private UUID id;
        @Getter @Setter private Date spendDate;
        @Getter @Setter private String category;
        @Getter @Setter private Currency currency;
        @Getter @Setter private Double amount;
        @Getter @Setter private String description;
        @Getter @Setter private String username;
        public String toJson() {
                return GSON.toJson(this);
        }
}