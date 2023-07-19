package api_TDO;

import com.fasterxml.jackson.annotation.JsonProperty;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.*;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Builder
@Getter

//@Log4j  що та коли прокидувати у консоль
//@Data   getter setter equals and hashCode to string
public class PostDTOLombock {

    @Nullable
    @JsonProperty("location")
    private LocationDTO location;
    private Integer accuracy;
   private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;
    private String address;
    private List<String> types;
    private String website;
    private String language;
    private String place_id;




}
