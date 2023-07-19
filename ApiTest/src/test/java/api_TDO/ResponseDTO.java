package api_TDO;

import com.fasterxml.jackson.annotation.JsonProperty;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Builder
@Getter

public class ResponseDTO {
    String status;


    public  String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



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
